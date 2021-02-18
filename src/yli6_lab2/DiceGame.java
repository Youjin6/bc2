package yli6_lab2;

import java.util.Scanner;

/**
 * This DiceGame program implements an application that plays a cheated dice
 * game between the computer and the user.
 *
 * @author youjin
 * @version 1.0
 */
public class DiceGame {

    /**
     * Prints out the introduction message.
     */
    public static void intro() {
        System.out.println("This is a game of you versus the computer." +
                " We will each\nhave one die. We roll our own die and " +
                "the higher number\nwins. We roll ten times and the one" +
                " with the higher number\nof wins is the grand winner.");
    }

    /**
     * Prints out the goodbye message.
     */
    public static void goodbye() {
        System.out.println("\nThanks for playing!");
    }


    /**
     * plays a cheated dice game between the computer and the user as many
     * times as the users want.
     *
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        // Call intro method
        intro();

        String quit;        // repeats the game
        final String NO = "no"; // holds "no"
        int computerValue;      // the value of computer's dice
        int userValue;          // the value of user's dice
        int countComputer = 0;  // initializes the times that computer wins
        int countUser = 0;      // initializes the times that users win

        final int ROLL_TIMES = 10; // holds the numbers of roll


        // Creates a Computer object
        Computer computer = new Computer();

        // Creates an user object
        User user = new User();

        // Creates an Scanner object
        Scanner keyboard = new Scanner(System.in);

        // Repeats the game as many times as the users want
        do {
            System.out.println();
            for (int roll = 1; roll <= ROLL_TIMES; roll++) {

                // Display the number of roll
                System.out.printf("Roll %d of " + ROLL_TIMES + ":\n", roll);

                // Computer rolls the dice
                computer.rollDice();

                // Gets the value of computer's dice
                computerValue = computer.getDieValue();

                // Displays out the information
                System.out.printf("I rolled a %d.\n", computerValue);

                // Ask the users if they are ready.
                System.out.print("Ready to roll? (Press ENTER when ready) ");
                keyboard.nextLine();

                // Users rolls the dice
                user.rollDice();

                /// Gets the value of user's dice
                userValue = user.getDieValue();

                // Displays out the information
                System.out.printf("You rolled a %d\n", userValue);
                System.out.println();

                // Counts how many times they win
                if (computerValue > userValue) {
                    countComputer++;
                } else if (computerValue < userValue) {
                    countUser++;
                }
            }

            // Prints out how many time they totally win
            System.out.printf("I won %d times.\n", countComputer);
            System.out.printf("You won %d times.\n", countUser);

            // Displays out the grand winner
            if (countComputer > countUser) {
                System.out.println("Grand winner is me!");
            } else if (countComputer < countUser) {
                System.out.println("Grand winner is you!");
            } else {
                System.out.println("We are tied!");
            }
            countComputer = 0;
            countUser = 0;

            // Ask the users if they want to repeat
            System.out.print("\nReady to play? (no to quit) ");
            quit = keyboard.nextLine();

        } while (!NO.equalsIgnoreCase(quit));

        // Closes the Scanner
        keyboard.close();

        // Call goodbye
        goodbye();
    }
}
