package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {

    private String name;
    private int address;

    public void init (ArrayList<String> args) {

        name = args.get(0);
    }
    public void execute (VirtualMachine vm) {

        vm.Push(vm.getPc());
        vm.setPc(address);
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
