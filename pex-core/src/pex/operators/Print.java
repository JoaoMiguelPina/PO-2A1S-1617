package pex.operators;

import pex.Expression;
import java.util.List;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing the Print operator
 */
public class Print extends Sequence {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public Print(List<Expression> expressions) {
    super(expressions);
  }
  
  /** Definida em pex.Expression
  * @return Value
  */
  public Value<?> accept(Visitor v){
    return v.visitPRINT(this);
  }
}
 