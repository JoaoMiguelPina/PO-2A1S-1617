/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import pex.operators.Program;

import pex.Manager;
import pex.Interpreter;
import pex.Expression;
import pex.atomic.Identifier;
import java.util.List;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Write (save) program to file.
 */
public class DoWriteProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _programName;
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoWriteProgram(Manager receiver) {
    super(Label.WRITE_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    try{
      _form.parse();
      Program prog =  new Program();
      prog = prog.idToProg(_programName.value(), _receiver);
      if(prog != null){
        prog.fileWrite(_filename.value());
      }
      else{
        _display.popup(Message.noSuchProgram(_programName.value()));
      }
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }

}
