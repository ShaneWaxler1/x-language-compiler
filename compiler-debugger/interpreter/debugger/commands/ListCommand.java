package interpreter.debugger.commands;

import interpreter.debugger.DebuggerVirtualMachine;
import interpreter.debugger.ui.DebuggerCommand;

import interpreter.debugger.Entry;

public class ListCommand extends DebuggerCommand{
    public ListCommand(){

    }

    @Override
    public void execute(){
        for(Entry e : DebuggerVirtualMachine.entries){
            if(e.isBreakPointLine()){
                System.out.println(e.getSourceLine());
            }
        }
    }
}
