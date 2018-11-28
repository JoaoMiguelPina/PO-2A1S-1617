/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pex.atomic.Identifier;
import pex.OpPrinter;
import pex.IdentiFinder;

/**
 * Show uninitialized identifiers.
 */
public class DoShowUninitializedIdentifiers extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowUninitializedIdentifiers(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    IdentiFinder i = new IdentiFinder();
    _receiver.accept(i);
    for(Identifier id: i.showUNIT()){
      OpPrinter p = new OpPrinter();
      id.accept(p);
      _display.addLine(p.toString());
    }
    _display.display(); 
  }

}
