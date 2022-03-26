package interpreter.debugger;

import java.util.HashMap;

import interpreter.CodeTable;

public class DebuggerCodeTable {
  private static HashMap<String, String> codeMap = new HashMap<>();

  public static void init() {
    CodeTable.init();

    codeMap.put("LINE", "debuggercodes.LineByteCode");
    codeMap.put("FORMAL", "debuggercodes.FormalByteCode");
    codeMap.put("FUNCTION", "debuggercodes.FunctionByteCode");
    // Initialize the new byte codes required for debugging:
    // codeMap.put(... etc. ...)
  }

  public static String get(String code) {
    String result = codeMap.get(code.trim().toUpperCase());

    if(result == null) {
      return CodeTable.get(code);
    } else {
      return result;
    }
  }
}