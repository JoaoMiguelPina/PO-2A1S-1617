package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing the Gt operator
 */
public class Gt extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public Gt(Expression first, Expression second) {
    super(first, second);
  }
  
  /** Definida em pex.Expression
  * @return Value
  */
  public Value<?> accept(Visitor v){
    return v.visitGT(this);
  }
  
}
