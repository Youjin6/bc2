package yli6_lab6;

/**
 * Calculate rule of RPN
 *
 * @author youjin
 * @version 1.0
 */
public class RPN {
    // stack to keep the data
    private Stack myStack;

    /**
     * Constructor
     */
    RPN() {
        myStack = new Stack();
    }

    /**
     * Evaluates the expression and gets the result
     *
     * @param expression An input String
     * @return The result
     */
    double evaluate(String expression) {
        double num1;    // first number
        double num2;    // second number
        double result;  // result
        int count = 0;  // count
        String operator; // keeps the operator

        // Splits the input message
        String[] input = expression.split(" ");

        // Parse each element
        while (count < input.length) {
            // push the number to the stack
            if (strToDigit(input[count]) != null) {
                myStack.push(strToDigit(input[count]));
            }

            // Calculate the numbers
            else {
                operator = input[count];
                if ("+".equals(operator) || "-".equals(operator) ||
                        "*".equals(operator) || "/".equals(operator)) {
                    // elements in stack less than 2
                    if (myStack.size() < 2)
                        throw new IllegalArgumentException("too " +
                                "many operators!");
                    if (myStack.size() >= 2) {
                        switch (operator) {
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
                    throw new IllegalArgumentException("Unknown operator: "
                            + operator);
            }
            count++;
        }
        return myStack.peek();
    }

    /**
     * Parse the String to digit
     *
     * @param input The input string
     * @return A double or null
     */
    private Double strToDigit(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            return null;
        }
    }
}
