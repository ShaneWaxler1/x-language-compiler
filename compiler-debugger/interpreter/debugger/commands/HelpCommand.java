package interpreter.debugger.commands;

import interpreter.debugger.ui.DebuggerCommand;

public class HelpCommand extends DebuggerCommand{

    public HelpCommand(){

    }
    
    @Override
    public void execute(){
        System.out.println(
            "set\nlist\nlocals\nsource\nstep\ncontinue\nexit"
        );
    }
}
