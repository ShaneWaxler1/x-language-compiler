package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnByteCode extends ByteCode{
  private String toString = "";
  private String toStringAppendVal;

  public ReturnByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    vm.returnAddrPop();
    vm.removeEnvRec();
    toStringAppendVal = String.valueOf(vm.peekRunTime());
  }
  
  @Override
  public void init(String[] arg){
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
    String name = "";
    if(arg.length>1){
      for(int i = 0; i < arg[1].length(); i++){
        if(arg[1].charAt(i) == '<'){
          name = arg[1].substring(0, i);
          break;
        }
      }
      toString = String.format("%-25.25sexit %s: ", toString, name);
    }
  }

  @Override
  public String toString(){
    if(!toString.equals("RETURN ")){
      return toString + toStringAppendVal;
    }else{
      return toString;
    }
  }
}
