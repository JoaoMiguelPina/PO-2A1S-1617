/** @version  */
package pex.app.main;

import java.io.IOException;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<Manager> {
  /** Input field. */
  Input<String> _filename;
  
  /**
   * @param receiver
   */
  public DoSave(Manager receiver) {
    super(Label.SAVE, receiver);
    _filename = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    String id = _receiver.getIntIdName();
    try{
      if(id.equals("") && _receiver.getIntChanges() == true){
        _form.parse();
        _receiver.doSave(_filename.value());
      }
      else{
        if (_receiver.getIntChanges() == true){
          _receiver.doSave(id);
        }
      }
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }
}
