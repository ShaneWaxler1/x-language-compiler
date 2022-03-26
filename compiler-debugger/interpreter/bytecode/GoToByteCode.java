package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GoToByteCode extends ByteCode{
  private String label;
  private String toString = "";

  public GoToByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    vm.branch(label);
  }
  
  @Override
  public void init(String[] arg){
    label = arg[1];
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
  }

  @Override
  public String toString(){
    return toString;
  }
}
