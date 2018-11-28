package pex;

import java.io.Serializable;
import pex.operators.Program;
import pex.atomic.Identifier;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


/**
 * Manages the interpreter.
 */
public class Manager implements Serializable{

  /**Interpreter*/
  private Interpreter _interpreter;

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;
  
  /**
  *Manager constructor
  * @param null
  */
  public Manager(){
    _interpreter = new Interpreter();
  }
  
  /**Get the interpreter
  * @return interpreter
  */
  public Interpreter getInterpreter(){
    return _interpreter;
  }
  
  /**Set a new interpreter
  * @param inter
  */
  public void setInterpreter(Interpreter inter){
    _interpreter = inter;
  }
  
  /**Gets the parser from the interpreter
  * @return Parser
  */
  public Parser getIntParser(){
    return this.getInterpreter().getParser();
  }
  
  /**Gets a Program from the interpreter
  * @return Program
  */
  public Program getIntProg(Identifier id){
    return this.getInterpreter().programGet(id);
  }
  
  /**Opens a saved interpreter
  * @param filename
  */
  public void openInt(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
    Interpreter newInt = (Interpreter) ois.readObject();
    newInt.identifierSet(filename);
    ois.close();
    this.setInterpreter(newInt);
  }
  
  /**Saves the interpreter on the disk
  * @param filename
  */
  public void doSave(String filename) throws IOException{
    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
    this.getInterpreter().identifierSet(filename);
    this.getInterpreter().changesSet(false);
    oos.writeObject(this.getInterpreter());
    oos.close();
  }
  
   /**Get the interpreter's change status
  * @return boolean
  */
  public boolean getIntChanges(){
    return _interpreter.changesGet();
  }
  
  
  /**Set the interpreter's change status
  * @param state
  */
  public void setIntChanges(boolean state){
    _interpreter.changesSet(state);
  }
  
   /**Get the interpreter's id name
  * @return String
  */
  public String getIntIdName(){
    return _interpreter.identifierGet().getName();
  }
  
  /**Set a new interpreter
  * 
  */
  public void setNewInt(){
    Interpreter newInt = new Interpreter();
    _interpreter = newInt;
  }
  
  /**Puts a new program on the hashmap
  * @param programName
  */
  public void newProgram(String programName){
    Program prog = new Program();
    Identifier newId = new Identifier(programName);
    this.getInterpreter().programPut(newId, prog);
    this.setIntChanges(true);
  }
  
  /**Reads a program from the disk
  * @param filename
  * @param manager
  */  
  public void readProgram(String filename) throws ParserException{
    Identifier newId = new Identifier(filename);
    this.getInterpreter().programPut(newId, this.getIntParser().parseProgramFile(filename));
    this.setIntChanges(true);
  }
  
  
  /**Imports a file
  * @param filename
  */
  public void importFile(String filename) throws ParserException{
    Identifier id = new Identifier("import");
    Interpreter interpreter = this.getInterpreter();
    interpreter.programPut(id, this.getIntParser().parseProgramFile(filename));
    this.setIntChanges(true);
  }

}
 
