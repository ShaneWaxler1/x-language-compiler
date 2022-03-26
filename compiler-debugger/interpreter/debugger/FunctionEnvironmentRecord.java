package interpreter.debugger;

import java.util.Hashtable;

class Binder {
  private Object value;
  private String prevtop;
  private Binder tail;

  Binder(Object v, String p, Binder t){
    value = v; prevtop = p; tail = t;
  }

  Object getValue() { return value; }
  String getPrevtop() { return prevtop; }
  Binder getTail() { return tail; }
}

public class FunctionEnvironmentRecord {
  private Hashtable <String, Binder> SymbolTable = new Hashtable<>();
  private String name;
  private int start;
  private int end;
  private int line;

  private String top;
  private Binder marks;

  public FunctionEnvironmentRecord(){

  }

  public void beginScope() {
    marks = new Binder(null, top, marks);
    top = null;
  }

  public void setFunctionInfo(String functionName, int startingLineNumber, int endingLineNumber) {
    name = functionName;
    start = startingLineNumber;
    end = endingLineNumber;
  }

  public void setCurrentLineNumber(int currentLineNumber) {
    line = currentLineNumber;
  }

  public void enter(String symbol, int value) {
    SymbolTable.put(symbol, new Binder(value, top, SymbolTable.get(symbol)));
    top = symbol;
  }

  public void pop(int count) {
    for(int i = 0; i < count; i++){
      Binder e = SymbolTable.get(top);
      if (e.getTail()!=null) SymbolTable.put(top,e.getTail());
	    else SymbolTable.remove(top);
	    top = e.getPrevtop();
    }
  }

  @Override
  public String toString(){
    StringBuffer s = new StringBuffer();
    for(String key: SymbolTable.keySet()){
      s.append(
        String.format("%s: %d\n", key, SymbolTable.get(key).getValue())
      );
    }
    return s.toString();
  }

  /**
   * Utility method to test your implementation. The output should be:
   * (<>, -, -, -, -)
   * (<>, g, 1, 20, -)
   * (<>, g, 1, 20, 5)
   * (<a/4>, g, 1, 20, 5)
   * (<b/2, a/4>, g, 1, 20, 5)
   * (<b/2, a/4, c/7>, g, 1, 20, 5)
   * (<b/2, a/1, c/7>, g, 1, 20, 5)
   * (<b/2, a/4>, g, 1, 20, 5)
   * (<a/4>, g, 1, 20, 5)
   */
  public static void main(String[] args) {
    FunctionEnvironmentRecord record = new FunctionEnvironmentRecord();

    record.beginScope();
    System.out.println(record);

    record.setFunctionInfo("g", 1, 20);
    System.out.println(record);

    record.setCurrentLineNumber(5);
    System.out.println(record);

    record.enter("a", 4);
    System.out.println(record);

    record.enter("b", 2);
    System.out.println(record);

    record.enter("c", 7);
    System.out.println(record);

    record.enter("a", 1);
    System.out.println(record);

    record.pop(2);
    System.out.println(record);

    record.pop(1);
    System.out.println(record);
  }
}