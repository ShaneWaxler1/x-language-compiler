package interpreter;

import java.util.Stack;
import java.util.Vector;

public class RunTimeStack {

  private Stack<Integer> framePointers = new Stack<Integer>();  // Keeps integer value for the bottom index of each frame
  // This may not be the right parameterized type!!
  private Vector<Integer> runStack = new Vector<Integer>();

  public RunTimeStack() {
    framePointers.push(0);
  }

  /**
   * The purpose of this function is to dump the RunTimeStack for the 
   * purpose of debugging.
   */
  
  public void dump() {
    String print = "]";
    int n = framePointers.size()-1;
    int size = runStack.size();
    for(int i = size - 1; i >= 0; i--){
      print = runStack.elementAt(i) + print;
      if(i==0){
        print = "[" + print;
      }
      else if(i==framePointers.elementAt(n)){
        n--;
        print = "] [" + print;
      }
      else{
        print = "," + print;
      }
    }
    if(print !="]"){
      System.out.println(print);
    }
  }

  /**
   * @return a String of all the elements in the top frame for CallByteCode to print
   */
  public String returnFrame(){
    String returnFrame = "";
    for(int i = framePointers.peek(); i < runStack.size(); i++){
      returnFrame = returnFrame + runStack.get(i) + ',';
    }

    if ((returnFrame != null) && (returnFrame.length() > 0)) {
      returnFrame = returnFrame.substring(0, returnFrame.length() - 1);
    }

    return returnFrame;
  }

  /**
   * Returns the top item on the runtime stack.
   */
  public int peek() {
    return runStack.lastElement();
  }

  /**
   * Pops the top item from the runtime stack, returning the item.
   */
  public int pop() {
    int ret = runStack.elementAt(runStack.size() - 1);
    runStack.removeElementAt(runStack.size() - 1);
    return ret;
  }

  /**
   * Push an item on to the runtime stack, returning the item that was just 
   * pushed.
   */
  public int push(int item) {
    runStack.add(item);
    return item;
  }

  /**
   * This second form with an Integer parameter is used to load literals onto the
   * stack.
   */
  public Integer push(Integer i) {
    runStack.add(i);
    return i;
  }

  /**
   * Start a new frame, where the parameter offset is the number of slots
   * down from the top of the RunTimeStack for starting the new frame.
   */
  public void newFrameAt(int offset) {
    framePointers.push(runStack.size()-offset);
  }

  /**
   * We pop the top frame when we return from a function; before popping, the
   * functions’ return value is at the top of the stack so we’ll save the value,
   * pop the top frame, and then push the return value.
   */
  public void popFrame() {
    int val = runStack.lastElement();
    while(runStack.size() != framePointers.peek()){
      pop();
    }
    runStack.add(val);
    framePointers.pop();
  }

  /**
   * Used to store into variables.
   */
  public int store(int offset) {
    int store = pop();
    runStack.set(framePointers.peek()+offset, store);
    return store;
  }

  /**
   * Used to load variables onto the stack.
   */
  public int load(int offset) {
    int ret = runStack.get(framePointers.peek()+offset);
    runStack.add(ret);
    return ret;
  }
}