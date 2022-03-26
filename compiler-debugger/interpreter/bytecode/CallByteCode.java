package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallByteCode extends ByteCode{
  private String funcName;
  private String toString = "";
  private String toStringAppend;

  public CallByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    vm.returnAddrPush();
    vm.branch(funcName);
    toStringAppend = vm.stringFrame();
  }
  
  @Override
  public void init(String[] arg){
    funcName = arg[1];
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }

    String name;
    if(arg.length>1){
      if(arg[1].indexOf('<')>=0){
        name = arg[1].substring(0,arg[1].indexOf('<'));
      }else{
        name = arg[1];
      }
      toString = String.format("%-25.25s %s(", toString, name);
    }
  }

  public String toString(){
    return toString + toStringAppend + ')';
  }
}
