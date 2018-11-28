package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing the Ne operator
 */
public class Ne extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public Ne(Expression first, Expression second) {
    super(first, second);
  }
  
  /** Definida em pex.Expression
  * @return Value
  */
  public Value<?> accept(Visitor v){
    return v.visitNE(this);
  }
}
