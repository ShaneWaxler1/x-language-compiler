package interpreter;

import java.io.*;
import interpreter.debugger.Debugger;
import interpreter.debugger.*;

public class Interpreter {

  protected ByteCodeLoader byteCodeLoader;
  protected VirtualMachine vm;

  public Interpreter(String codeFile) {
    try {
      DebuggerCodeTable.init();
      byteCodeLoader = new ByteCodeLoader(codeFile);
    } catch (IOException e) {
      System.out.println("**** " + e);
    }
  }

  public void run() throws IOException{
    Program program = byteCodeLoader.loadCodes();
    vm = new VirtualMachine(program);
    vm.executeProgram();
  }

  public static void main(String args[]) throws IOException{
    if (args.length == 0 || args.length > 2) {
      System.out.println("*** Incorrect usage, try: java interpreter.Interpreter <file>");
      System.exit(1);
    }

    if(args.length == 2 && !args[0].equals("-d")) {
      System.out.println("*** Incorrect usage, try: java interpreter.Interpreter -d <basefilename>");
      System.exit(1);
    }

    if(args.length == 2 && args[0].equals("-d")) {
      (new Debugger(args[1] + ".cod")).run();
    } else {
      (new Interpreter(args[0])).run();
    }
  }
}