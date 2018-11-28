
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


import java.util.TreeSet;

import pex.Visitor;

public class IdentiFinder implements Visitor{
  
  /** All program's identifiers TreeSet. */
  private TreeSet<Identifier> _allIDS;
  
  /** Uninitialized identifier TreeSet. */
  private TreeSet<Identifier> _unitIDS;
  
  public IdentiFinder(){
    _allIDS = new TreeSet<Identifier>();
    _unitIDS = new TreeSet<Identifier>();
  }

  /** This visitor searches for identifiers and puts them in two sets, one with * the unitialized ones and an overall set
  */
  
  /** These methods recursively go down to the atomic operators and try to find * ids to put in the sets
  * @return Value
  */
  public Value<?> visitADD(Add c){
    c.first().accept(this); 
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitAND(And c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitCALL(Call c){
    c.argument().accept(this);
    return null;
  }
  
  
  public Value<?> visitDIV(Div c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitEQ(Eq c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitGE(Ge c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitGT(Gt c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitIF(If c){
    c.first().accept(this);
    c.second().accept(this);
    c.third().accept(this);
    return null;
  }
  
  
  public Value<?> visitLE(Le c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitLT(Lt c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitMOD(Mod c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitMUL(Mul c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitNE(Ne c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitNEG(Neg c){
    c.argument().accept(this);
    return null;
  }
  
  
  public Value<?> visitNOT(Not c){
    c.argument().accept(this);
    return null;
  }
  
  
  public Value<?> visitOR(Or c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitPRINT(Print c){
    for(Expression e: c.getAll()){
      e.accept(this);
    }
    return null;
  }
  
  
  public Value<?> visitPROGRAM(Program c){
    for(Expression e: c.getAll()){
      e.accept(this);
    }
    return null;
  }
  
  
  public Value<?> visitREADI(Readi c){
    return null;
  }
  
  
  public Value<?> visitREADS(Reads c){
    return null;
  }
  
  
  public Value<?> visitSEQUENCE(Sequence c){
    for(Expression e: c.getAll()){
      e.accept(this);
    }
    return null;
  }
  
  /** This visit puts the ids in the overall set and removes them from the *unitialized set if they're there
  * @return Value
  */
  public Value<?> visitSET(Set c){
    Value<?> v = c.second().accept(this);
    if (_unitIDS.contains((Identifier)c.first())){
      _unitIDS.remove((Identifier)c.first());
    }
     _allIDS.add((Identifier)c.first());
    return v;
  }
  
  
  public Value<?> visitSUB(Sub c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  
  public Value<?> visitWHILE(While c){
    c.first().accept(this);
    c.second().accept(this);
    return null;
  }
  
  /** Puts all found visitors in both Uninitialized and overall sets
  * @return Value
  */
  public Value<?> visitIDENTIFIER(Identifier c){
      if(!(_allIDS.contains(c))){
        _allIDS.add(c);
        _unitIDS.add(c);
      }
    return new StringLiteral(c.getName());
  }
  
  
  public Value<?> visitSTRLITERAL(StringLiteral c){
    return null;
  }
  
  
  public Value<?> visitINTLITERAL(IntegerLiteral c){
    return null;
  }
  
  
  /** Both methods below return sets used by the app evaluator commands
  * @return TreeSet<Identifier>
  */
  public TreeSet<Identifier> showALL(){
    return _allIDS;
  }
  
  public TreeSet<Identifier> showUNIT(){
    return _unitIDS;
  }
    
  
} 
