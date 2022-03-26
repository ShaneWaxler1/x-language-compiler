package interpreter.debugger.ui;

import interpreter.debugger.Debugger;

import java.util.HashMap;
import java.util.Scanner;

public class DebuggerShell {
  private HashMap<String, String> commands = new HashMap<>() {{
    put("exit", "ExitCommand");
    put("continue", "ContinueCommand");
    put("?", "HelpCommand");
    put("list", "ListCommand");
    put("locals", "LocalsCommand");
    put("set", "SetCommand");
    put("source", "SourceCommand");
    put("step", "StepCommand");
  }};

  private Scanner s = new Scanner(System.in);

  public DebuggerShell(Debugger debugger) {

  }

  public DebuggerCommand prompt() {
    // Create the correct command object here, based on user interaction,
    // and return

    DebuggerCommand dc = null;

    while(dc==null){
      System.out.print("Type ? for help\n> ");
      dc = getCommand(s.nextLine());
    }
    return dc;
  }

  public DebuggerCommand getCommand(String c){
    try {
      DebuggerCommand dc = (DebuggerCommand) Class.forName("interpreter.debugger.commands." + commands.get(c)).getDeclaredConstructor().newInstance();
      return dc;
    } catch (Exception e) {
      return null;
    }
  }
}