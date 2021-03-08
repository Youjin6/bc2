package yli6_lab6;

import java.util.Scanner;

/**
 * Implements a RPN calculator
 * @author youjin
 * @version 1.0
 */
public class RPNCalculator {
    /**
     * Test the RPNCalculator
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        // Call printIntro
        printIntro();

        double result;  // holds the result
        String input;   // holds input string
        RPN rpn = new RPN(); // create a RPN object
        System.out.println("(blank line to quit)");
        // Repeat the game
        do {
            input = getInput();
            if (!quit(input)) {
            result = rpn.evaluate(input);
            System.out.println(result);}
        } while (!input.equals(""));

        // Call printBye
        printBye();

    }

    /**
     * Check if quit the program
     * @param inputString An input string
     * @return True if quit
     */
    public static boolean quit(String inputString) {
        boolean quit = false;   // holds true or false
        if (inputString.equals("")){
            quit = true;
        }
        return quit;
    }

    /**
     * Gets the input from the user
     * @return
     */
    public static String getInput() {
        String inputString;     // holds input string
        Scanner keyboard = new Scanner(System.in);
        System.out.print("calc> ");
        inputString = keyboard.nextLine();

        return inputString;
    }

    /**
     * Prints out the introduction message
     */
    public static void printIntro(){
        System.out.println("RPN Calculator\n");
    }

    /**
     * Prints out bye
     */
    public static void printBye(){
        System.out.println("\nBye!");
    }

}
