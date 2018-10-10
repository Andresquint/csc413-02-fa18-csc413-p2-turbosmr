package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {

        this.program = program;
    }

    protected void executeProgram() {

        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {

            ByteCode code = program.getCode(pc);
            code.execute(this);
        }
        pc++;
    }
    public void setPc(int pc) {

        this.pc = pc;
    }

    public int getPc() {

        return this.pc;
    }

    public void isRunning() {


    }

    public void FrameAt(int offset) {

        runStack.newFrameAt(offset);
    }

    public void dump(){

        runStack.dump();
    }

    public int Pop() {

        return runStack.pop();
    }

    public void Push(int n) {

        runStack.push(n);}
}
