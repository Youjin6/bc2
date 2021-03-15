package yli6_lab3;

import java.util.Scanner;

/**
 * Play a guess number game with the users.
 *
 * @author Yucong Li
 * @version 1.0
 */
public class Lab3 {

    /**
     * Tests and simulates a guss number game
     *
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        final int MIN = 1;      // The minimum range
        final int MAX = 10;      // The maximum range
        int number;                 // The input number
        String repeat;              // To hold yes or no

        // Prints out a new line
        Scanner keyboard = new Scanner(System.in);

        // Call displayIntro
        displayIntro();

        // Prints out a new line.
        System.out.println();

        // Repeats the games as many times as the users want.
        do {
            System.out.println();

            // Creat a guessGame object
            GuessGame guessGame = new GuessGame(MIN, MAX);

            // Call getNum method
            number = getNum(MIN, MAX);


            // Process the users' guess
            while (!guessGame.guess(number)) {
                number = getNum(MIN, MAX);
                guessGame.displayStatistics();
            }

            // Call displayCorrect
            displayCorrect();

            // Displays out how many time the users guessed
            System.out.println("you guessed " + guessGame.count + " times.");

            // Asks the user if they want to player1Play the game again.
            System.out.print("\nReady to player1Play again? (no to quit) ");
            repeat = keyboard.nextLine();

        } while (!repeat.equalsIgnoreCase("no"));

        // Call displayBye
        displayBye();

        // Close the Scanner
        keyboard.close();
    }


    /**
     * Displays the introduction message of the game to the standard output.
     */
    public static void displayIntro() {
        System.out.print("This is a guessing game where you will guess a " +
                "number\nand I tell you if it is too low or too high.");
    }


    /**
     * Displays the goodbye message.
     */
    public static void displayBye() {
        System.out.println("\nThanks for playing!");
    }


    /**
     * Gets a guessing number from the users.
     *
     * @param min The minimum range
     * @param max The maximum range
     * @return A guessing number
     */
    public static int getNum(int min, int max) {
        int number;  // input number

        // Creates a keyboard object.
        Scanner keyboard = new Scanner(System.in);

        // Asks the users for a number between min range and max range.
        System.out.print("Guess a number between " + min + " and " + max +
                ": ");
        number = keyboard.nextInt();
        keyboard.nextLine();

        return number;
    }


    /**
     * Displays out the "correct" message.
     */
    public static void displayCorrect() {
        System.out.println("That's correct!");
    }
}
