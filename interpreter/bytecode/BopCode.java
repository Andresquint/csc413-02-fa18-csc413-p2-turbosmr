package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    private String operator;

    public void init(ArrayList<String> args) {

        operator = args.get(0);

    }

    public void execute(VirtualMachine vm) {

        int num1 = vm.Pop();
        int num2 = vm.Pop();

        if (operator.equals("+")) {

            vm.Push(num2 + num1);

        } else if (operator.equals("-")) {

            vm.Push(num2 - num1);

        } else if (operator.equals("*")) {

            vm.Push(num2 * num1);

        } else if (operator.equals("/")) {

            vm.Push(num2 / num1);

        } else if (operator.equals("-")) {

            vm.Push(num2 - num1);

        } else if (operator.equals("==")) {

            int equal = 0;

            if (num2 == num1) {
                equal = 1;
            }
            vm.Push(equal);
        }
        else if (operator.equals("!=")) {

            int notEqual = 0;

            if (num2 != num1) {
                notEqual = 1;
            }
            vm.Push(notEqual);
        }
        else if (operator.equals("<=")) {

            int lessThanEqual = 0;

            if(num2 <= num1) {
                lessThanEqual = 1;
            }
            vm.Push(lessThanEqual);
        }

        else if (operator.equals(">=")) {

            int greaterThanEqual = 0;

            if (num2 >= num1) {
                greaterThanEqual = 1;
            }
            vm.Push(greaterThanEqual);
        }
            else if (operator.equals("<")) {

            int notEqual = 0;

            if (num2 < num1) {
                notEqual = 1;
            }
            vm.Push(notEqual);
        }
        else if (operator.equals(">")) {

            int greaterThan = 0;

            if(num2 > num1) {
                greaterThan = 1;
            }
            vm.Push(greaterThan);
        }
        else if (operator.equals("|")) {

            int or = 0;

            if(num2 == 1 || num1 == 1) {
                or = 1;
            }
            vm.Push(or);
        }
        else if (operator.equals("&")) {

            int and = 0;

            if (num2 == 1 & num1 ==1 ) {
                and = 1;
            }
            vm.Push(and);
        }
    }
}

