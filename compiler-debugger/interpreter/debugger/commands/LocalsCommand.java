package interpreter.debugger.commands;

import interpreter.VirtualMachine;
import interpreter.debugger.ui.DebuggerCommand;

public class LocalsCommand extends DebuggerCommand{

    public LocalsCommand(){

    }

    @Override
    public void execute(){
        System.out.println(VirtualMachine.getLocals());
    }
}
