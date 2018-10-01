package interpreter.bytecode;

import interpreter.VirtualMachine;

public abstract class ByteCode {

    public abstract void init (String a, String b);
    public abstract void execute (VirtualMachine vm);

}
