package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadByteCode extends ByteCode{
  private int n;
  private String toString = "";

  public LoadByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    vm.loadRuntime(n);
  }
  
  @Override
  public void init(String[] arg){
    n = Integer.parseInt(arg[1]);
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
    if(arg.length > 2){
      toString = String.format("%-25.25s<load %s>", toString, arg[2]);
    }
  }

  @Override
  public String toString(){
    return toString;
  }
}
