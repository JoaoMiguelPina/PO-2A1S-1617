/** @version  */
package pex.app.main;

import pex.Manager;
import pex.atomic.Identifier;
import pex.operators.Program;
import pex.app.evaluator.EvaluatorMenu;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Menu;

/**
 * Open menu for managing programs.
 */
public class DoManageProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _program;

  /**
   * @param receiver
   */
  public DoManageProgram(Manager receiver) {
    super(Label.MANAGE_PROGRAM, receiver);
    _program = _form.addStringInput(Message.requestProgramId());
  }
  
  

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    Program prog = new Program();
    prog = prog.manageProgram(_program.value(), _receiver);
    if(prog != null){
      Menu menu = new EvaluatorMenu(_receiver.getInterpreter(), prog);
      menu.open();
    }
    else{
      _display.popup(Message.noSuchProgram(_program.value()));
    }
  }

}
