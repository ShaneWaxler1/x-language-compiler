package interpreter;

import java.util.Vector;
import java.util.HashMap;
import interpreter.bytecode.ByteCode;
import interpreter.debugger.*;

public class Program {
  private Vector<ByteCode> program;
  private HashMap<String, Integer> labels = new HashMap<>();

  public Program(){
    program = new Vector<>();
  }

  public HashMap<String,Integer> copyLabels(){
    return labels;
  }

  public ByteCode getCode(int programCounter) {
    return program.elementAt(programCounter);
  }
  
  public void addCode(String[] code){
    try{
      ByteCode bc = (ByteCode) Class.forName("interpreter.bytecode." + DebuggerCodeTable.get(code[0])).getDeclaredConstructor().newInstance();
      bc.init(code);
      program.add(bc);
      if(DebuggerCodeTable.get(code[0])== "LabelByteCode"){
        labels.put(code[1], program.size()-1);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}