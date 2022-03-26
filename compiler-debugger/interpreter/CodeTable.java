package interpreter;

import java.util.Hashtable;

public class CodeTable {
  private static Hashtable<String, String> CodeTable = new Hashtable<>();

  public static void init () {
    CodeTable.put("HALT", "HaltByteCode");
    CodeTable.put("POP", "PopByteCode");
    CodeTable.put("FALSEBRANCH", "FalseBranchByteCode");
    CodeTable.put("GOTO", "GoToByteCode");
    CodeTable.put("STORE", "StoreByteCode");
    CodeTable.put("LOAD", "LoadByteCode");
    CodeTable.put("LIT", "LitByteCode");
    CodeTable.put("ARGS", "ArgsByteCode");
    CodeTable.put("CALL", "CallByteCode");
    CodeTable.put("RETURN", "ReturnByteCode");
    CodeTable.put("BOP", "BopByteCode");
    CodeTable.put("READ", "ReadByteCode");
    CodeTable.put("WRITE", "WriteByteCode");
    CodeTable.put("LABEL", "LabelByteCode");
    CodeTable.put("DUMP", "DumpByteCode");
  }

  public static String get(String code) {
    return CodeTable.get(code);
  }
}