package interpreter.debugger;

import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

import java.io.BufferedReader;
import java.io.FileReader;
import interpreter.Interpreter;
import interpreter.Program;
import interpreter.debugger.ui.DebuggerShell;

public class Debugger extends Interpreter {
  private DebuggerShell shell;
  private Vector<Entry> entries = new Vector<>();
  Stack<FunctionEnvironmentRecord> environmentRecords = new Stack<>();

  public Debugger(String baseFileName) {
    super(baseFileName);
    // Update to add the correct extensions to the base file name to
    // load the byte code file, as well as to load the source file
    try {
      String xFileName = baseFileName.substring(0, baseFileName.length()-4);
      BufferedReader source = new BufferedReader(new FileReader(xFileName));
      String line = source.readLine();
      int lineno = 1;
      while(line!=null){
        entries.add(new Entry(lineno, line, false));
        line = source.readLine();
        lineno++;
      }

      for(Entry e: entries){
        System.out.println(e.getSourceLine());
      }

      source.close();
    } catch (Exception e) {}
  }

  @Override
  public void run() throws IOException{
    shell = new DebuggerShell(this);
    
    Program program = byteCodeLoader.loadCodes();
    
    DebuggerVirtualMachine vm = new DebuggerVirtualMachine(program, this);

    shell.prompt().execute();

    vm.executeProgram();
  }

  public Vector<Entry> getEntries() {
      return entries;
  }
}
