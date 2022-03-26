package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;
import interpreter.debugger.FunctionEnvironmentRecord;

public class FunctionByteCode extends ByteCode{
    private String toString = "";
    private String name;
    private int start;
    private int end;

    public FunctionByteCode(){
    }

    @Override
    public void execute(VirtualMachine vm){
        FunctionEnvironmentRecord add = new FunctionEnvironmentRecord();
        add.setFunctionInfo(name,start,end);
        vm.pushEnvRec(add);
    }

    @Override
    public void init(String[] arg){
        name = arg[1];
        try {
            start = Integer.parseInt(arg[2]);
            end = Integer.parseInt(arg[3]);
        } catch (Exception e) {
        }
    }

    @Override
    public String toString(){
        return toString;
    }
}
