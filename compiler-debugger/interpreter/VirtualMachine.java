/**
 * DO NOT provide a method that returns components contained WITHIN the VM (this 
 * is the exact situation that will break encapsulation) - you should request 
 * that the VM performs operations on its components. This implies that the VM 
 * owns the components and is free to change them, as needed, without breaking 
 * clients' code (e.g., suppose I decide to change the name of the variable that 
 * holds my runtime stack - if your code had referenced that variable then your 
 * code would break. This is not an unusual situation - you can consider the 
 * names of methods in the Java libraries that have been deprecated).
 * 
 * Consider that the VM calls the individual ByteCodes' execute method and 
 * passes itself as a parameter. For the ByteCode to execute, it must invoke 
 * one or more methods in the runStack. It can do this by executing 
 * VM.runStack.pop(); however, this does break encapsulation. To avoid this, 
 * you'll need to have a corresponding set of methods within the VM that do 
 * nothing more than pass the call to the runStack. e.g., you would want to 
 * define a VM method:
 *     public int popRunStack() {
 *       return runStack.pop();
 *     }
 * called by, e.g.,
 *     int temp = VM.popRunStack();
 */
package interpreter;

import java.util.HashMap;
import java.util.Stack;
import interpreter.bytecode.*;
import interpreter.debugger.FunctionEnvironmentRecord;

public class VirtualMachine {

  private int pc;
  private RunTimeStack runTimeStack;
  // This may not be the right parameterized type!!
  private Stack<Integer> returnAddresses;
  private boolean isRunning;
  private boolean dumpState;
  private boolean go;
  private Program program;
  private HashMap<String, Integer> labels;
  private static int lineno;
  private static Stack<FunctionEnvironmentRecord> environmentRecords;

  public VirtualMachine(Program program) {
    this.program = program;
    labels = this.program.copyLabels();
    runTimeStack = new RunTimeStack();
    returnAddresses = new Stack<>();
    dumpState = false;
    go = false;
    pc = 0;
    environmentRecords = new Stack<>();
  }

  public void executeProgram() {
    isRunning = true;

    while (isRunning) {
      ByteCode code = program.getCode(pc);
      code.execute(this);
      if(dumpState&&go){
        System.out.println(code);
        runTimeStack.dump();
      }
      go = true;
      pc++;
    }
  }
  
  //add code so bytecode can talk to vm
  public void stop(){
    isRunning = false;
  }


  // FER
  public void pushEnvRec(FunctionEnvironmentRecord fenv){
    environmentRecords.push(fenv);
  }

  public void enterEnvRec(String sym, int val){
    environmentRecords.peek().enter(sym, val);
  }

  public static String getLocals(){
    return environmentRecords.peek().toString();
  }

  public void removeEnvRec(){
    environmentRecords.pop();
  }

  public void popEnvRec(int n){
    environmentRecords.peek().pop(n);
  }

  public String getEnvRec(){
    return environmentRecords.peek().toString();
  }
  //


  public int popRunTime(){
    return runTimeStack.pop();
  }

  public void pushRunTime(int i){
    runTimeStack.push(i);
  }

  public int storeRuntime(int n){
    // return runTimeStack.store(n);
    return runTimeStack.store(n);
  }

  public void loadRuntime(int n){
    runTimeStack.load(n);
  }

  public void setLineNo(int no){
    lineno = no;
  }

  public static int getLineNo(){
    return lineno;
  }

  public void newFrame(int n){
    runTimeStack.newFrameAt(n);
  }

  public int getPc(){
    pc++;
    return pc;
  }

  public void branch(String label){
    pc = labels.get(label);
  }

  public void dump(){
    runTimeStack.dump();
  }

  public void returnAddrPop(){
    pc = returnAddresses.pop();
    runTimeStack.popFrame();
  }

  public void returnAddrPush(){
    returnAddresses.push(pc);
  }

  public int peekRunTime(){
    return runTimeStack.peek();
  }

  public void dumpOn(){
    dumpState = true;
    go = false;
  }

  public void dumpOff(){
    dumpState = false;
    go = false;
  }

  public Boolean getDumpState(){
    return dumpState;
  }

  public Boolean getGo(){
    return go;
  }

  public void setGo(){
    go = true;
  }

  public String stringFrame(){
    return runTimeStack.returnFrame();
  }
}