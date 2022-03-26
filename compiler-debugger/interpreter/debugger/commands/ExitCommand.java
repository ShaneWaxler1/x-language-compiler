package interpreter.debugger.commands;

import interpreter.debugger.ui.DebuggerCommand;

public class ExitCommand extends DebuggerCommand{
    
    public ExitCommand(){

    }

    @Override
    public void execute(){
        System.exit(1);
    }
}
