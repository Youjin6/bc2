package yli6_p3;

import java.util.Scanner;

/**
 * This SillyCardGame plays a card game with the user.
 *
 * @author Youjin Li
 * @version 1.0
 */
public class SillyCardGame {
    /**
     * Tests and repeat the game as many times as the users want
     *
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        String repeat; // Holds y or n
        Scanner keyboard = new Scanner(System.in);

        // Call printIntro
        printIntro();

        // Repeats the game as many times as the users want
        do {
            try {
                startGame();
            } catch (GameModel.GameTiedException e) {
                System.out.println("Both discard and dealer's " +
                        "pile are empty. It's a tie!");
            }
            System.out.print("\nDo you want to player1Play again? (y/n): ");
            repeat = keyboard.nextLine();
        } while (!"n".equalsIgnoreCase(repeat));

        // Calls printBye
        printBye();

        // Closes the keyboard
        keyboard.close();
    }

    /**
     * Prints  out the goodbye message.
     */
    public static void printBye() {
        System.out.println("\nThank for playing the Card Game!");
    }

    /**
     * Start the game.
     *
     * @throws GameModel.GameTiedException When tied
     */
    public static void startGame() throws GameModel.GameTiedException {
        // Create a GameModel object
        GameModel game = new GameModel();
        // Prints out initial status
        printCardsInHand();
        printPlayerCards(game.player1, game.player2);

        // Continue player1Play when players queue is not empty
        while (!game.player1.empty() && !game.player2.empty()) {
            // Player 1's turn
            player1Go(game, game.player1, game.shuffledCards);

            // Check if player 1 won
            if (game.player1.empty()) {
                printCardsInHand();
                printPlayerCards(game.player1, game.player2);
                break;
            } else {
                printCardsInHand();
                printPlayerCards(game.player1, game.player2);
            }

            // Player 2's turn
            player2Go(game, game.player2, game.shuffledCards);

            // Prints out the end status
            printCardsInHand();
            printPlayerCards(game.player1, game.player2);
        }
        if (game.player1.empty()) {
            System.out.println("\nPlayer 1 won.");
        } else if (game.player2.empty()) {
            System.out.println("Player 2 won.");
        }
    }

    /**
     * Prints out the introduction message
     */
    public static void printIntro() {
        System.out.println("Welcome to Silly Little Games' new Card Game!\n" +
                "(add information to describe the game...)\n" +
                "\n" + "Good luck!!!!");
    }

    /**
     * Prints out card in hand
     */
    public static void printCardsInHand() {
        System.out.println("\n\nCards in hand.\n" + "--------------\n");
    }

    /**
     * Prints out the player's queue
     *
     * @param player1 Player1
     * @param player2 Player2
     */
    public static void printPlayerCards(Queue<Integer> player1,
                                        Queue<Integer> player2) {
        System.out.println("Player 1 : " + player1);
        System.out.println("Player 2 : " + player2);
    }


    /**
     * Prints out the game message after each turn
     *
     * @param game         A gameModel object
     * @param player       The player
     * @param shuffledCard Dealer's card pile
     * @throws GameModel.GameTiedException When tied
     */
    public static void player1Go(GameModel game, Queue<Integer> player,
                                 Stack<Integer> shuffledCard)
            throws GameModel.GameTiedException {

        final int DEALER_TOP = 0;   // the dealer's top
        final int PLAYER_TOP = 1;   // the player's top
        final int MESSAGE = 2;      // holds the game result
        final int PICK_NUM = 3;     // how many card to pick
        String[] record; // holds the information

        // deal card to the player
        record = game.dealCards(shuffledCard, player);

        System.out.printf("Player 1's turn.\n" +
                        "Top of the stack is %s.\n" +
                        "Your card %s is %s %s\n" +
                        "%s\n", record[DEALER_TOP], record[PLAYER_TOP],
                record[MESSAGE], record[DEALER_TOP], record[PICK_NUM]);
    }

    /**
     * Prints out the game message after each turn
     *
     * @param game         A gameModel object
     * @param player       The player
     * @param shuffledCard Dealer's card pile
     * @throws GameModel.GameTiedException When tied
     */
    public static void player2Go(GameModel game, Queue<Integer> player,
                                 Stack<Integer> shuffledCard)
            throws GameModel.GameTiedException {

        final int DEALER_TOP = 0;   // the dealer's top
        final int PLAYER_TOP = 1;   // the player's top
        final int MESSAGE = 2;      // holds the game result
        final int PICK_NUM = 3;     // how many card to pick
        String[] record; // holds the information

        // deal card to the player
        record = game.dealCards(shuffledCard, player);

        System.out.printf("Player 2's turn.\n" +
                        "Top of the stack is %s.\n" +
                        "Your card %s is %s %s\n" +
                        "%s\n", record[DEALER_TOP], record[PLAYER_TOP],
                record[MESSAGE], record[DEALER_TOP], record[PICK_NUM]);
    }
}
