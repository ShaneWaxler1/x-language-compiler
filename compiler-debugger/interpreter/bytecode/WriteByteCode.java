package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteByteCode extends ByteCode{
  private String toString = "";
  public WriteByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    System.out.println(vm.peekRunTime());
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
