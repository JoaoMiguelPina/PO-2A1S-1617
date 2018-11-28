/*  */
package pex;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;

/**
 * An expressions can be evaluated to produce a value.
 */
public abstract class Expression implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;
  
  /** This method receives the visitors and applies them to the operators
  * @return Value
  */
  public abstract Value<?> accept(Visitor v);
}
