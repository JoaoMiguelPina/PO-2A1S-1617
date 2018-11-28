/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pt.tecnico.po.ui.DialogException;
import pex.app.BadFileException;
import pex.operators.Program;

import pex.Manager;
import pex.Parser;
import pex.atomic.Identifier;
import pex.ParserException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Read existing program.
 */
public class DoReadProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoReadProgram(Manager receiver) {
    super(Label.READ_PROGRAM, receiver);
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    try{
      _form.parse();
      _receiver.readProgram(_filename.value());
    }
    catch (ParserException e) {
        throw new BadFileException(_filename.value());
    }
    
  }

}
