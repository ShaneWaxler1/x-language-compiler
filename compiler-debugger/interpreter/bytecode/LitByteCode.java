package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitByteCode extends ByteCode{
  private int n;
  private String toString = "";
  private String name = "";

  public LitByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    vm.pushRunTime(n);
    if(!name.equals("")){
      vm.enterEnvRec(name, n);
    }
  }
  
  @Override
  public void init(String[] arg){
    n = Integer.parseInt(arg[1]);
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
    if(arg.length>2){
      toString = String.format("%-25.25sint %s", toString, arg[2]);
      name = arg[2];
    }
  }

  @Override
  public String toString(){
    return toString;
  }
}
