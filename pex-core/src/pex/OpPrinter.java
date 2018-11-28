
package pex;

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
import pex.Value;
import pex.Expression;

public class OpPrinter implements Visitor{

  /** Final string to be returned */
  String _program = "";
  
  public String toString(){
    return _program;
  }

  /** These methods add parts of the final string to be returned
  */
  
  public Value<?> visitADD(Add c){
    _program += "(add ";
    c.first().accept(this); 
    _program +=  " " ;
    c.second().accept(this); 
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitAND(And c){
    _program += "(and ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitCALL(Call c){
    _program += "(call ";
    c.argument().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitDIV(Div c){
    _program += "(div ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitEQ(Eq c){
    _program += "(eq ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitGE(Ge c){
    _program += "(ge ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitGT(Gt c){
    _program += "(gt ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitIF(If c){
    _program += "(if ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += " ";
    c.third().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitLE(Le c){
    _program += "(le ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitLT(Lt c){
    _program += "(lt ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitMOD(Mod c){
    _program += "(mod ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitMUL(Mul c){
    _program += "(mul ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitNE(Ne c){
    _program += "(ne ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitNEG(Neg c){
    _program += "(neg ";
    c.argument().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitNOT(Not c){
    _program += "(not ";
    c.argument().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitOR(Or c){
    _program += "(or ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitPRINT(Print c){
    _program += "(print";
    for(Expression e: c.getAll()){
      _program += " ";
      e.accept(this);
    }
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitPROGRAM(Program c){
    for(Expression e: c.getAll()){
      e.accept(this);
      _program += "\n";
    }
    return null;
  }
  
  
  public Value<?> visitREADI(Readi c){
    _program += "(readi)";
    return null;
  }
  
  
  public Value<?> visitREADS(Reads c){
    _program += "(reads)";
    return null;
  }
  
  
  public Value<?> visitSEQUENCE(Sequence c){
    _program += "(seq";
    for(Expression e: c.getAll()){
      _program += " ";
      e.accept(this);
    }
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitSET(Set c){
    _program += "(set ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitSUB(Sub c){
    _program += "(sub ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitWHILE(While c){
    _program += "(while ";
    c.first().accept(this);
    _program += " ";
    c.second().accept(this);
    _program += ")";
    return null;
  }
  
  
  public Value<?> visitIDENTIFIER(Identifier c){
    _program += c.getName();
    return null;
  }
  
  
  public Value<?> visitSTRLITERAL(StringLiteral c){
    _program += "\"" + c.getValue() + "\"";
    return null;
  }
  
  
  public Value<?> visitINTLITERAL(IntegerLiteral c){
    _program += c.getValue();
    return null;
  }
  
}