/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pex.Expression;
import pex.Visitor;
import pex.app.Evaluator;

/**
 * Run program.
 */
public class DoRunProgram extends ProgramCommand {
  
  /**
   * @param interpreter 
   * @param receiver
   */
  public DoRunProgram(Interpreter interpreter, Program receiver) {
    super(Label.RUN_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute(){
    Evaluator e = new Evaluator(_interpreter);
    _receiver.accept(e);
  }
}
