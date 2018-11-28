
package pex.app;

import pex.operators.Add;
import pex.operators.Mul;
import pex.operators.Not;
import pex.operators.Program;
import pex.operators.Sequence;
import pex.operators.Neg;
import pex.operators.Sub;
import pex.operators.Div;
import pex.operators.Mod;
import pex.operators.Lt;
import pex.operators.Le;
import pex.operators.Ge;
import pex.operators.Gt;
import pex.operators.Eq;
import pex.operators.Ne;
import pex.operators.And;
import pex.operators.Or;
import pex.operators.Set;
import pex.operators.Print;
import pex.operators.Readi;
import pex.operators.Reads;
import pex.operators.If;
import pex.operators.While;
import pex.operators.Call;
import pex.atomic.Identifier;
import pex.atomic.IntegerLiteral;
import pex.atomic.StringLiteral;

import pex.Visitor;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Form;
import pt.tecnico.po.ui.Input;
import pex.Expression;
import pex.Visitor;
import pex.Value;
import pex.Interpreter;

public class Evaluator implements Visitor{

  /** This visitor evaluates Expressions and returns their overall result */
  

  /** Interpreter used by the methods below, belonging to the main app*/
  private Interpreter _interpreter;
  
  /** The constructor receives an Interpreter to be modified by some of the    * methods below
  */
  public Evaluator(Interpreter interpreter){
    _interpreter = interpreter;
  }

  /** This auxiliar function returns an int from a value 
  * @return int
  * @param Value
  */
  public int aux(Value<?> v){
    return ((IntegerLiteral) v).getValue();
  }
  
  /** This auxiliar function receives an error String and displays it
  * @param string
  */
  public void errorAux(String string){
    Display display = new Display();
    display.add(string);
    display.display();
  }
  

  /** The arithmetic ops return an IntegerLiteral of their value
  * @return Value
  */
  public Value<?> visitADD(Add c){
    try{
      return new IntegerLiteral(aux(c.first().accept(this))+ aux(c.second().accept(this)));
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Add");
      return new IntegerLiteral(0);
    }
  }
  
  /** The logical ops return either 0(false) or 1(true)
  * @return Value
  */
  public Value<?> visitAND(And c){
    try{
      if(aux(c.first().accept(this)) != 0){
        if(aux(c.second().accept(this)) != 0){
          return new IntegerLiteral(1);
        }
        return new IntegerLiteral(0);
      }
      return new IntegerLiteral(0);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação And");
      return new IntegerLiteral(0);
    }
  }
  
  /** Calls a program from the interpreters hashmap and executes it
  * @return Value
  */
  public Value<?> visitCALL(Call c){
    try{
      Value<?> v= new IntegerLiteral(0);
      Display display = new Display();
      String program = "" + c.argument().accept(this).getValue();
      Identifier id = new Identifier(program);
      Program prog = _interpreter.programGet(id);
      
      if(prog != null){
        v = prog.accept(this);
        return v;
      }
      
      display.addLine("O programa " + program + " não existe");
      display.display();
      return new IntegerLiteral(0);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Call");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitDIV(Div c){
    try{
      return new IntegerLiteral(aux(c.first().accept(this)) / aux(c.second().accept(this)));
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Div");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitEQ(Eq c){
    try{
      if( aux(c.first().accept(this)) == aux(c.second().accept(this))){
        return new IntegerLiteral(1);
      }
      return new IntegerLiteral(0);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Eq");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitGE(Ge c){
    try{
      if( aux(c.first().accept(this)) >= aux(c.second().accept(this))){
        return new IntegerLiteral(1);
      }
      return new IntegerLiteral(0);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Ge");
      return new IntegerLiteral(0);
    }
  }
  
 
  public Value<?> visitGT(Gt c){
    try{
      if( aux(c.first().accept(this))> aux(c.second().accept(this))){
        return new IntegerLiteral(1);
      }
      return new IntegerLiteral(0);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Gt");
      return new IntegerLiteral(0);
    }
  }
  
  /** If the first operand is true returns the second, else returns the third
  * @return Value
  */
  public Value<?> visitIF(If c){
    try{
      Value<?> v = new IntegerLiteral(0);
      if(aux(c.first().accept(this)) != 0){
        v = c.second().accept(this);
        return v;
      }
      v = c.third().accept(this);
      return v;
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação If");
      return new IntegerLiteral(0);
    }
  }
  

  public Value<?> visitLE(Le c){
    try{
      if( aux(c.first().accept(this)) <= aux(c.second().accept(this))){
        return new IntegerLiteral(1);
      }
      return new IntegerLiteral(0);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Le");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitLT(Lt c){
    try{
      if( aux(c.first().accept(this)) < aux(c.second().accept(this))){
        return new IntegerLiteral(1);
      }
      return new IntegerLiteral(0);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Lt");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitMOD(Mod c){
    try{
      return new IntegerLiteral(aux(c.first().accept(this)) % aux(c.second().accept(this)));
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Mod");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitMUL(Mul c){
    try{
      return new IntegerLiteral(aux(c.first().accept(this)) * aux(c.second().accept(this)));
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Mul");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitNE(Ne c){
    try{
      if( aux(c.first().accept(this)) != aux(c.second().accept(this))){
        return new IntegerLiteral(1);
      }
      return new IntegerLiteral(0);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Ne");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitNEG(Neg c){
    try{
      int i = -1 * aux(c.argument().accept(this));
      return new IntegerLiteral(i);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Neg");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitNOT(Not c){
    try{
      if(aux(c.argument().accept(this)) != 0){
        return new IntegerLiteral(0);
      }
      return new IntegerLiteral(1);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Not");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitOR(Or c){
    try{
      if(aux(c.first().accept(this)) == 0){
        if(aux(c.second().accept(this)) != 0){
          return new IntegerLiteral(1);
        }
        return new IntegerLiteral(0);
      }
      return new IntegerLiteral(1);
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Or");
      return new IntegerLiteral(0);
    }
  }
  
  /** Prints the arguments, returns the value of the last argument
  * @return Value
  */
  public Value<?> visitPRINT(Print c){
  
    Value<?> v = new IntegerLiteral(0);
    Display display = new Display();
    String buffer = "";
    
    for(Expression e: c.getAll()){
      v = e.accept(this);
      buffer += v.getValue();
    }
    display.add(buffer);
    display.display();
    return v;
  }
  
  /** Goes through the expressions of the program and applies the different * * * methods to the operators
  * @return Value
  */
  public Value<?> visitPROGRAM(Program c){
    Value<?> v = new IntegerLiteral(0);
    for (Expression exp : c.getAll()){
      v = exp.accept(this);
    }
    return v;
  }
  
  /** Gets an input int from the user and returns it
  * @return Value
  */
  public Value<?> visitREADI(Readi c){
    try{
      Form _form = new Form();
      Input<Integer> _input;
      _input = _form.addIntegerInput(null);
      _form.parse();
      return new IntegerLiteral(_input.value());
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Readi");
      return new IntegerLiteral(0);
    }
  }
  
  /** Gets a string from a user and returns it
  * @return Value
  */
  public Value<?> visitREADS(Reads c){
    try{
      Form _form = new Form();
      Input<String> _input;
      _input = _form.addStringInput(null);
      _form.parse();
      return new StringLiteral(_input.value());
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Reads");
      return new IntegerLiteral(0);
    }
  }
  
  /** Returns the last value of the sequence but executes all of them
  * @return Value
  */
  public Value<?> visitSEQUENCE(Sequence c){
    Value<?> v = new IntegerLiteral(0);
    for(Expression e: c.getAll()){
      v = e.accept(this);
    }
    return v;
  }
  
  /** Gives a value to an identifier, puts it in the map if he isn't there or * * replaces it if it's there already
  * @return Value
  */
  public Value<?> visitSET(Set c){
    try{
      Value<?> v = c.second().accept(this);
      _interpreter.identifiersPut((Identifier)c.first(), v);
      return v;
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Set");
      return new IntegerLiteral(0);
    }
  }
  
  
  public Value<?> visitSUB(Sub c){
    try{
      return new IntegerLiteral(aux(c.first().accept(this)) - aux(c.second().accept(this)));
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação Sub");
      return new IntegerLiteral(0);
    }
  }
  
  /** While the first operand is true, executes the second one, returns the * * * last value of the first one
  * @return Value
  */
  public Value<?> visitWHILE(While c){
    try{
      Value<?> v;
      while(aux(v = c.first().accept(this)) != 0){
        c.second().accept(this);
      }
      return v;
    }
    catch(ClassCastException e){
      errorAux("Erro nos operandos da operação While");
      return new IntegerLiteral(0);
    }
  }
  
  /** Returns the identifier if it already exists or 0 otherwise
  * @return Value
  */
  public Value<?> visitIDENTIFIER(Identifier c){
    Value<?> v = _interpreter.identifiersGet(c);
    if(v != null){
      return v;
    }
    return new IntegerLiteral(0);
  }
  
  /** Returns a StringLiteral
  * @return Value
  */
  public Value<?> visitSTRLITERAL(StringLiteral c){
    return c;
  }
  
  /** Returns an IntegerLiteral
  * @return Value
  */
  public Value<?> visitINTLITERAL(IntegerLiteral c){
    return c;
  }
  
} 
