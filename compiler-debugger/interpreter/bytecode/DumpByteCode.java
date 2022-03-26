package interpreter.bytecode;

import interpreter.VirtualMachine;

public class DumpByteCode extends ByteCode{
  private String flag;
  private String toString = "";

  public DumpByteCode(){
  }

  @Override
  public void execute(VirtualMachine vm){
    if(flag.equals("ON")){
      vm.dumpOn();
    }
    else if(flag.equals("OFF")){
      vm.dumpOff();
    }
  }

  @Override
  public void init(String[] arg){
    flag = arg[1];
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
  }

  @Override
  public String toString(){
    return toString;
  }
}
