package interpreter.debugger.commands;

import interpreter.debugger.DebuggerVirtualMachine;
import interpreter.debugger.ui.DebuggerCommand;

public class StepCommand extends DebuggerCommand{
    
    public StepCommand(){
    }

    @Override
    public void execute(){
        DebuggerVirtualMachine.step = true;
    }
}
