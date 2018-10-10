package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private int num;

    public void init (ArrayList<String> args) {

        num = (int) Integer.parseInt(String.valueOf(args));
    }
    public void execute (VirtualMachine vm) {

        vm.FrameAt(num);
    }

    public String toString () {

        return " ARGS" + num;
    }
}
