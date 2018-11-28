/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.Expression;
import pex.operators.Program;
import pex.Visitor;
import pex.OpPrinter;

/**
 * Show program (present code).
 */
public class DoShowProgram extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowProgram(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    OpPrinter p = new OpPrinter();
    _receiver.accept(p);
    _display.add(p.toString());
    _display.display();
  }

}
