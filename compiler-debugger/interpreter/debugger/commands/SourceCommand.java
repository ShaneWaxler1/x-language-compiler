package interpreter.debugger.commands;

import interpreter.debugger.DebuggerVirtualMachine;
import interpreter.debugger.Entry;
import interpreter.debugger.ui.DebuggerCommand;
import interpreter.VirtualMachine;

public class SourceCommand extends DebuggerCommand{
    
    public SourceCommand(){

    }

    @Override
    public void execute(){
        for(Entry e: DebuggerVirtualMachine.entries){
            if(e.getLineNumber() == VirtualMachine.getLineNo()+2){
                System.out.println("-> " + e.getSourceLine().substring(3));
            }else{
                System.out.println(e.getSourceLine());
            }
        }
    }
}
