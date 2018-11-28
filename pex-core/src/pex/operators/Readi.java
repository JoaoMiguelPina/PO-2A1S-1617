package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/** Class for describing Readi. */
public class Readi extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** The argument expression. */
  Expression _argument;

  /**
   * @param argument
   */
  public Readi() {
  }

  /**
   * @return the argument
   */
  public Expression argument() {
    return _argument;
  }
  
  /** Definida em pex.Expression
  * @return Value
  */
  public Value<?> accept(Visitor v){
    return v.visitREADI(this);
  }
}
 