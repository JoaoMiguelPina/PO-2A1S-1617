package pex;

import pex.Expression;
import pex.operators.Program;
import pex.atomic.Identifier;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Interprets the expressions
 */
public class Interpreter implements Serializable{

  /** Program Map. */
  private Map<Identifier, Program> _programs;
  
  /** Identifier Map. */
  private Map<Identifier, Value<?>> _identifiers;
  
  /**Parser for programs*/
  private Parser _parser;
  
  /**Interpreter's identifier*/
  private Identifier _id;
  
  /**Save the change status on the interpreter*/
  private boolean _changes;

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;
  
  /**
  *Interpreter constructor
  * @param null
  */
  public Interpreter(){
    _programs = new HashMap<Identifier, Program>();
    _identifiers = new TreeMap<Identifier, Value<?>>();
    _parser = new Parser();
    _id = new Identifier("");
    _changes = true;
  }
  
  /**Gets a program from the hashmap
  * @return Program
  */
  public Program programGet(Identifier identifier){
    return _programs.get(identifier);
  }
  
  /**Puts a program on the hashmap
  * @param identifier
  * @param program
  */
  public void programPut(Identifier identifier, Program program){
    _programs.put(identifier, program);
  }
  
  /**Get the interpreter's identifier
  * @return Identifier
  */
  public Identifier identifierGet(){
    return _id;
  }
  
  /**Set the interpreter's identifier
  * @param name
  */
  public void identifierSet(String name){
    _id = new Identifier(name);
  }
  
  /**Get the interpreter's parser
  * @return Parser
  */
  public Parser getParser(){
    return _parser;
  }
  
  /**Get the interpreter's change status
  * @return boolean
  */
  public boolean changesGet(){
    return _changes;
  }
  
  /**Sets a new status
  * @param bool
  */
  public void changesSet(boolean bool){
    _changes = bool;
  }
  
  /**Puts a value on the Treemap
  * @param identifier
  * @param value
  */
  public void identifiersPut(Identifier id, Value<?> v){
    _identifiers.put(id, v);
  }
  
  /**Gets a value from the treemap
  * @return Value
  */
  public Value<?> identifiersGet(Identifier id){
    return _identifiers.get(id);
  }
  
  /**Parse an expression
  * @return Expression
  */
  public Expression parseIntExp(String description) throws ParserException{
    return this.getParser().parse(description);
  }
  
}
 
