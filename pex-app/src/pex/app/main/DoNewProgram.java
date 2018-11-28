/** @version  */
package pex.app.main;

import pex.Manager;
import pex.operators.Program;
import pex.atomic.Identifier;
import pex.Interpreter;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Create new program.
 */
public class DoNewProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _programName;

  /**
   * @param receiver
   */
  public DoNewProgram(Manager receiver) {
    super(Label.NEW_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    _receiver.newProgram(_programName.value());
  }

}
