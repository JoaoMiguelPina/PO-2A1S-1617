
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

public interface Visitor{
  
  /** Funçoes que terão todos os visitors que implementem esta interface
  * @return Value
  */
  
  Value<?> visitADD(Add c);
  
  Value<?> visitAND(And c);
  
  Value<?> visitCALL(Call c);
  
  Value<?> visitDIV(Div c);
  
  Value<?> visitEQ(Eq c);
  
  Value<?> visitGE(Ge c);
  
  Value<?> visitGT(Gt c);
  
  Value<?> visitIF(If c);
  
  Value<?> visitLE(Le c);
  
  Value<?> visitLT(Lt c);
  
  Value<?> visitMOD(Mod c);
  
  Value<?> visitMUL(Mul c);
  
  Value<?> visitNE(Ne c);
  
  Value<?> visitNEG(Neg c);
  
  Value<?> visitNOT(Not c);
  
  Value<?> visitOR(Or c);
  
  Value<?> visitPRINT(Print c);
  
  Value<?> visitPROGRAM(Program c);
  
  Value<?> visitREADI(Readi c);
  
  Value<?> visitREADS(Reads c);
  
  Value<?> visitSEQUENCE(Sequence c);
  
  Value<?> visitSET(Set c);
  
  Value<?> visitSUB(Sub c);
  
  Value<?> visitWHILE(While c);
  
  Value<?> visitIDENTIFIER(Identifier c);
  
  Value<?> visitINTLITERAL(IntegerLiteral c);
  
  Value<?> visitSTRLITERAL(StringLiteral c);
}
