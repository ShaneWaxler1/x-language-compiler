package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltByteCode extends ByteCode{
  private String toString = "";

  public HaltByteCode(){
  }

  @Override
  public void execute(VirtualMachine vm){
    vm.stop();
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
