package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

public class LineByteCode extends ByteCode {
    private String toString = "";
    private int line;

    public LineByteCode(){

    }

    @Override
    public void execute(VirtualMachine vm){
        vm.setLineNo(line);
    }

    @Override
    public void init(String[] arg){
        try {
            line = Integer.parseInt(arg[1]);
        } catch (Exception e) {}
    }

    @Override
    public String toString(){
        return toString;
    }
}
