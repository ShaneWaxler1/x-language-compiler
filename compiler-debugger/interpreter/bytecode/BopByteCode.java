package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopByteCode extends ByteCode{
  private String bop;
  private String toString = "";

  public BopByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    int first = vm.popRunTime();
    int second = vm.popRunTime();
    
    if(bop.equals("+")){
      vm.pushRunTime(second + first);
    }
    else if(bop.equals("-")){
      vm.pushRunTime(second - first);
    }
    else if(bop.equals("/")){
      vm.pushRunTime(second/first);
    }
    else if(bop.equals("*")){
      vm.pushRunTime(second*first);
    }
    else if(bop.equals("==")){
      if(second == first){
        vm.pushRunTime(1);
      }else{
        vm.pushRunTime(0);
      }
    }
    else if(bop.equals("!=")){
      if(second != first){
        vm.pushRunTime(1);
      }else{
        vm.pushRunTime(0);
      }
    }
    else if(bop.equals("<=")){
      if(second<=first){
        vm.pushRunTime(1);
      }else{
        vm.pushRunTime(0);
      }
    }
    else if(bop.equals(">")){
      if(second>first){
        vm.pushRunTime(1);
      }else{
        vm.pushRunTime(0);
      }
    }
    else if(bop.equals(">=")){
      if(second>=first){
        vm.pushRunTime(1);
      }else{
        vm.pushRunTime(0);
      }
    }
    else if(bop.equals("<")){
      if(second<first){
        vm.pushRunTime(1);
      }else{
        vm.pushRunTime(0);
      }
    }
    else if(bop.equals("|")){
      if(second > 0 || first > 0){
        vm.pushRunTime(1);
      }else{
        vm.pushRunTime(0);
      }
    }
    else if(bop.equals("&")){
      if(second > 0 && first > 0){
        vm.pushRunTime(1);
      }else{
        vm.pushRunTime(0);
      }
    }
  }
  
  @Override
  public void init(String[] arg){
    bop = arg[1];
    for(int i = 0; i < arg.length; i++){
      toString += arg[i] + " ";
    }
  }

  @Override
  public String toString(){
    return toString;
  }
}
