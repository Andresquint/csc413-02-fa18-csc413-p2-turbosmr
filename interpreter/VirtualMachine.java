package interpreter;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;

    protected VirtualMachine(Program program) {

        this.program = program;
    }

}