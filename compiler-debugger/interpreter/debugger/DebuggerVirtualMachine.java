package interpreter.debugger;

import java.util.Vector;
import interpreter.Program;
import interpreter.VirtualMachine;
import interpreter.bytecode.*;
import interpreter.debugger.ui.DebuggerShell;

public class DebuggerVirtualMachine extends VirtualMachine {
  private int pc;
  private Boolean isRunning;
  private Program program;
  private DebuggerShell shell;
  private Debugger debugger;

  public static Boolean step = false;
  public static Vector<Entry> entries;

  public DebuggerVirtualMachine(Program program, Debugger debugger) {
    super(program);
    this.program = program;
    this.debugger = debugger;
    shell = new DebuggerShell(debugger);
    entries = debugger.getEntries();
  }

  @Override
  public void executeProgram(){
    isRunning = true;

    while (isRunning) {
      ByteCode code = program.getCode(pc);
      code.execute(this);
      if(getDumpState()&&getGo()){
        System.out.println(code);
        dump();
      }

      if(step){
        step = false;
        shell.prompt().execute();
      }
      if(entries.get(getLineNo()+1).isBreakPointLine()){
          shell.prompt().execute();
      }

      setGo();
      pc = getPc();
    }
  }
}