package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {

    private String name;
    private int address;

    public void init (ArrayList<String> a) {

        name = a.get(0);
    }
    public void execute (VirtualMachine vm) {

    }

    public String getName(){

        return name;
    }

    public void setAddress(int address){

        this.address = address;
    }

    public int getAddress(){

        return this.address;
    }
}
