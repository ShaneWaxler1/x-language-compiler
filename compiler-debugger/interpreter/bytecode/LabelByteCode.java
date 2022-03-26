package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LabelByteCode extends ByteCode{
  private String toString = "";

  public LabelByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
  }
  
  @Override
  public void init(String[] arg){
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
  }

  @Override
  public String toString(){
    return toString;
  }
}
