package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsByteCode extends ByteCode{
  private int n;
  private String toString = "";

  public ArgsByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    vm.newFrame(n);
  }
  
  @Override
  public void init(String[] arg){
    n = Integer.parseInt(arg[1]);
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
  }

  @Override
  public String toString(){
    return toString;
  }
}
