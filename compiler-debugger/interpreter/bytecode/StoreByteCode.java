package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreByteCode extends ByteCode{
  private int n;
  private String toString = "";
  private String toStringAppend = "";

  public StoreByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    toStringAppend = String.valueOf(vm.storeRuntime(n));
  }
  
  @Override
  public void init(String[] arg){
    n = Integer.parseInt(arg[1]);
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
    toString = String.format("%-25.25s%s = ", toString, arg[2]);
  }

  @Override
  public String toString(){
    return toString + toStringAppend;
  }
}
