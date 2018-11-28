package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/** Class for describing Reads. */
public class Reads extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** The argument expression. */
  Expression _argument;

  /**
   * @param argument
   */
  public Reads() {
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
    return v.visitREADS(this);
  }
}