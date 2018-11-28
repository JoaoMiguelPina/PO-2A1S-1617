/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import pex.Interpreter;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Open existing interpreter.
 */
public class DoOpen extends Command<Manager> {

  /** Input field. */
  Input<String> _filename;
  
  /**
   * @param receiver
   */
  public DoOpen(Manager receiver) {
    super(Label.OPEN, receiver);
    _filename = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    try{
      _form.parse();
      _receiver.setIntChanges(false);
      _receiver.openInt(_filename.value());
    }
    catch(FileNotFoundException e){
        _display.popup(Message.fileNotFound());
    }
    catch(IOException e){
      e.printStackTrace();
    }
    catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }

}
