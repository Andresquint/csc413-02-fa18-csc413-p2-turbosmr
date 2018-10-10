package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap <String, Integer> labels = new HashMap();

    public Program() {

        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {

        return this.program.get(pc);
    }

    public int getSize() {

        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */

    public void addCode(ByteCode byteCode) {

        if (byteCode instanceof LabelCode) {

            LabelCode labelBranch = (LabelCode) byteCode;
            labels.put(labelBranch.getName(), program.size());
        }
    }

    public void resolveAddrs() {

        for (ByteCode byteCodeList : program) {

            if (byteCodeList instanceof GotoCode) {
                GotoCode changeBranch = (GotoCode) byteCodeList;
                changeBranch.setAddress(labels.get(changeBranch.getName()));

            } else if (byteCodeList instanceof FalseBranchCode) {
                FalseBranchCode changeBranch = (FalseBranchCode) byteCodeList;
                changeBranch.setAddress(labels.get(changeBranch.getName()));

            } else if (byteCodeList instanceof CallCode) {
                CallCode changeBranch = (CallCode) byteCodeList;
                changeBranch.setAddress(labels.get(changeBranch.getName()));
            }
        }
    }
}
