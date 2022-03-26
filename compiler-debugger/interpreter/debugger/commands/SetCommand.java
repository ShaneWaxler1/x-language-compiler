package interpreter.debugger.commands;

import interpreter.debugger.DebuggerVirtualMachine;
import interpreter.debugger.ui.DebuggerCommand;
import java.util.Scanner;


public class SetCommand extends DebuggerCommand{
    private Scanner s = new Scanner(System.in);

    public SetCommand(){

    }

    @Override
    public void execute(){
        System.out.print("Enter line number:\n> ");
        try {
            int index = Integer.parseInt(s.nextLine());
            DebuggerVirtualMachine.entries.get(index-1).setBreakpoint();
        } catch (Exception e) {
        }
    }
}
