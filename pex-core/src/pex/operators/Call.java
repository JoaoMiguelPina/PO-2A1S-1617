package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing the Call operator
 */
public class Call extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;
  
  /** The argument expression. */
  Expression _argument;

  /**
   * @param argument
   */
  public Call(Expression argument) {
    super(argument);
  }
  
  /** Definida em pex.Expression
  * @return Value
  */
  public Value<?> accept(Visitor v){
    return v.visitCALL(this);
  }
  
} 
