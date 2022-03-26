package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

public class FormalByteCode extends ByteCode{
    private String toString = "";
    private String name;
    private int offset;

    public FormalByteCode(){
    }

    @Override
    public void execute(VirtualMachine vm){
        vm.enterEnvRec(name, offset);
    }

    @Override
    public void init(String[] arg){
        name = arg[1];
        try {
            offset = Integer.parseInt(arg[2]);
        } catch (Exception e) {
        }
    }

    @Override 
    public String toString(){
        return toString;
    }
}
