package interpreter.debugger;

public class Entry{
    private int lineNo;
    private String sourceLine;
    private Boolean isBreakPointLine;
  
    public Entry(int l, String s, Boolean i){
      lineNo = l;
      sourceLine = String.format("%7d: %s", lineNo, s);
      isBreakPointLine = i;
    }
  
    public void setBreakpoint(){
      isBreakPointLine = true;
      sourceLine = sourceLine.substring(0,3) + '*' + sourceLine.substring(4);
    }
  
    public void removeBreakpoint(){
      isBreakPointLine = false;
    }
  
    public int getLineNumber(){
      return lineNo;
    }
    public String getSourceLine(){
      return sourceLine;
    }
    public Boolean isBreakPointLine(){
      return isBreakPointLine;
    }
  }