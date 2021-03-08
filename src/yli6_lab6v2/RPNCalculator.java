package yli6_lab6v2;

import java.util.Scanner;


public class RPNCalculator {
    public static void main(String[] args) {
        printIntro();

        double result;
        String input;
        RPN rpn = new RPN();
        System.out.println("(blank line to quit)");
        do {
            input = getInput();
            if (!quit(input)) {
            result = rpn.evaluate(input);
            System.out.println(result);}
        } while (!input.equals(""));

        printBye();

    }

    public static boolean quit(String inputString) {
        boolean quit = false;
        if (inputString.equals("")){
            quit = true;
        }
        return quit;
    }

    public static String getInput() {
        String inputString;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("calc> ");
        inputString = keyboard.nextLine();

        return inputString;
    }

    public static void printIntro(){
        System.out.println("RPN Calculator\n");
    }

    public static void printBye(){
        System.out.println("\nBye!");
    }

}
