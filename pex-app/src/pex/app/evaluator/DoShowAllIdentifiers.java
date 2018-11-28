/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pex.OpPrinter;
import pex.atomic.Identifier;
import pex.IdentiFinder;

/**
 * Show all program identifiers.
 */
public class DoShowAllIdentifiers extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowAllIdentifiers(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_ALL_IDENTIFIERS, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    IdentiFinder i = new IdentiFinder();
    _receiver.accept(i);
    for(Identifier id: i.showALL()){
      OpPrinter p = new OpPrinter();
      id.accept(p);
      _display.addLine(p.toString());
    }
    _display.display();      
  }

}
