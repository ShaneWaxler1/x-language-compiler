package interpreter.bytecode;

import java.util.Scanner;

import interpreter.VirtualMachine;

public class ReadByteCode extends ByteCode{
  private String toString = "";

  public ReadByteCode(){

  }

  @Override
  public void execute(VirtualMachine vm){
    Scanner read = new Scanner(System.in);
    System.out.println("Enter an integer: ");
    vm.pushRunTime(read.nextInt());
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
