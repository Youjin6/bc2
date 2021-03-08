package yli6_lab6v2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RPN {

    Stack myStack;
    private Pattern binopToken;


    RPN() {
        myStack = new Stack();
        binopToken = Pattern.compile("\\+|\\*|-|\\/|\\^");
    }

    double evaluate(String expression) {
        double num1;
        double num2;
        double result;

        String operator;


        Scanner scanner = new Scanner(expression);
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                myStack.push(scanner.nextDouble());
            }
            else if (scanner.hasNext(binopToken)) {
                String binop = scanner.next(binopToken);
                if (myStack.size() < 2)
                    throw new IllegalArgumentException("too " +
                            "many operators!");
                if (myStack.size() >= 2) {
                    switch (binop) {
                        case "+":
                            num1 = myStack.pop();
                            num2 = myStack.pop();
                            result = num2 + num1;
                            myStack.push(result);
                            break;
                        case "-":
                            num1 = myStack.pop();
                            num2 = myStack.pop();
                            result = num2 - num1;
                            myStack.push(result);
                            break;
                        case "*":
                            num1 = myStack.pop();
                            num2 = myStack.pop();
                            result = num2 * num1;
                            myStack.push(result);
                            break;
                        case "/":
                            num1 = myStack.pop();
                            num2 = myStack.pop();
                            result = num2 / num1;
                            myStack.push(result);
                            break;
                    }
                } else {
                    throw new IllegalArgumentException("not " +
                            "enough operators!");
                }
            } else
                throw new IllegalArgumentException("Unknown operator: " + scanner.next());
        }
        return myStack.peek();
    }

    /**
     * @param input
     * @return
     */
    private Double strToDigit(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isNum(String input) {
        return input.matches("[0-9]+");
    }
}
