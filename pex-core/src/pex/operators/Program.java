/*  */
package pex.operators;

import pex.Expression;
import pex.atomic.Identifier;
import pex.Interpreter;
import pex.Manager;
import pex.ParserException;
import pex.Parser;
import java.io.IOException;

import java.util.List;
import pex.Visitor;
import pex.OpPrinter;
import java.io.FileWriter;
import pex.Value;

/**
 * Class for describing programs.
 */
public class Program extends Sequence{

  /**
  * Program's default constructor
  * @param null
  */
  public Program(){
    //Default constructor
  }
  
  /**Opens the program manager menu
  * @return program
  */
  public Program manageProgram(String programName, Manager manager){
    Identifier compare = new Identifier(programName);
    Program prog = manager.getInterpreter().programGet(compare);
    return prog;
  }
  
  /**Converts an Identifier to a Program
  * @return program from an identifier (throws IOException)
  */
  public Program idToProg(String name, Manager manager) throws IOException{
    Identifier compare = new Identifier(name);
    Program prog = manager.getInterpreter().programGet(compare);
    return prog;
  }
  
  
  
  /**Writes a program to a file
  * @param filename
  */
  public void fileWrite(String filename) throws IOException{
    FileWriter fw = new FileWriter(filename);
    OpPrinter p = new OpPrinter();
    this.accept(p);
    fw.write(p.toString());
    fw.write("\n");
    fw.close();
  }
  
  /** Definida em pex.Expression
  * @return Value
  */
  public Value<?> accept(Visitor v){
    return v.visitPROGRAM(this);
  }
}
