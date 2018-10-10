package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {

        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {

    }

    public int peek() {

        if (runTimeStack != null && !runTimeStack.isEmpty()) {

            int lastElement = (int) runTimeStack.get(runTimeStack.size() - 1);
            return lastElement;
        }
        return 0;
    }

    public int pop() {

        if (runTimeStack != null && !runTimeStack.isEmpty()) {

            int lastElement = (int) runTimeStack.get(runTimeStack.size() - 1);
            int topVal = (int) runTimeStack.get(lastElement);
            runTimeStack.remove(lastElement);
            return topVal;
        }
        return 0;
    }

    public int push(int i) {

        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) {

        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame() {

        int returnVal;

        if (!(runTimeStack.isEmpty())) {

            returnVal = (int) runTimeStack.get(runTimeStack.size() - 1);

            while (runTimeStack.size() != framePointer.peek()) {

                runTimeStack.remove(runTimeStack.size() - 1);
            }

            framePointer.pop();
            runTimeStack.add(returnVal);

        }
    }

    public int store(int offset) {

        int storeValue = (int) runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, storeValue);
        return storeValue;
    }

    public int load(int offset) {

        int loadVal = (int) runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(loadVal);
        return loadVal;
    }

    public Integer push(Integer val) {

        runTimeStack.add(val);
        return val;
    }
}
