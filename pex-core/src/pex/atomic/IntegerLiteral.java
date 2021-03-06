/*  */
package pex.atomic;

import pex.Value;
import pex.Visitor;

/**
 * Class for describing syntactic tree leaves for holding integer values.
 */
public class IntegerLiteral extends Value<Integer> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param value
   */
  public IntegerLiteral(int value) {
    super(value);
  }
  
  /** Definida em pex.Expression
  * @return Value
  * @param Visitor
  */
  public Value<?> accept(Visitor v){
    return v.visitINTLITERAL(this);
  }

}
