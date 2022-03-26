package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopByteCode extends ByteCode{
  private int num;
  private String toString = "";

  public PopByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    for(int i = 0; i < num; i++){
      vm.popRunTime();
    }
    
    vm.popEnvRec(num);
  }
  
  @Override
  public void init(String[] arg){
    num = Integer.parseInt(arg[1]);
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
  }

  @Override
  public String toString(){
    return toString;
  }
}
