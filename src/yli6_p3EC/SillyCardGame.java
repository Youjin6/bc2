package yli6_p3EC;

import java.util.ArrayList;
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

        // Prints out welcome message.
        printIntro();

        // Repeats the game as many times as the users want.
        do {
            try {
                // start game
                startGame(getPlayer(keyboard));
            } catch (GameModel.GameTiedException e) {
                System.out.println("Both discard and dealer's pile are empty. " +
                        "It's a tie!");
            }
            System.out.print("\nDo you want to player1Play again? (y/n): ");
            repeat = keyboard.nextLine();
            System.out.println();
        } while (!"n".equalsIgnoreCase(repeat));

        // Calls printBye
        printBye();

        // Closes the keyboard
        keyboard.close();
    }

    /**
     * Get Player name list.
     *
     * @param keyboard A Scanner
     * @return A name list
     */
    public static String[] getPlayer(Scanner keyboard) {
        int playerNum;  // holds number of players

        System.out.print("How many players?(2-6): ");
        playerNum = keyboard.nextInt();
        keyboard.nextLine();
        String[] nameList = new String[playerNum];

        for (int i = 0; i < playerNum; i++) {
            System.out.print("Enter name of player #" + (i + 1) + ": ");
            nameList[i] = keyboard.nextLine();
        }
        return nameList;
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
     * @throws GameModel.GameTiedException Both dealer and discard pile is empty
     */
    public static void startGame(String[] nameList) throws GameModel.GameTiedException {
        int winner = 0;         // holds the winner
        boolean empty = false;  // true if one of the players queue is empty
        GameModel game = new GameModel(nameList);

        while (!empty) {
            for (int i = 0; i < game.playerList.size(); i++) {
                printCardsInHand();
                printPlayerCards(game.playerList);
                play(game, game.playerList.get(i), game.shuffledCards);
            }
            for (int i = 0; i < game.playerList.size(); i++) {
                if (game.playerList.get(i).getQueue().empty()) {
                    empty = true;
                    winner = i;
                }
            }
        }
        printCardsInHand();
        printPlayerCards(game.playerList);
        System.out.printf("\n%s won!", nameList[winner]);
        System.out.println();
    }

    /**
     * Prints out the introduction message
     */
    public static void printIntro() {
        System.out.println("""
                Welcome to Silly Little Games' new Card Game!
                (add information to describe the game...)

                Good luck!!!!""");
    }

    /**
     * Prints out card in hand
     */
    public static void printCardsInHand() {
        System.out.println("""


                Cards in hand.
                --------------
                """);
    }


    /**
     * Displays out the current cards in each player1Play's hand.
     *
     * @param playerList The player1Play list
     */
    public static void printPlayerCards(ArrayList<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println(playerList.get(i).getName() + ": " + playerList.get(i).getQueue());
        }
    }


    /**
     * Prints out the game message after each turn
     *
     * @param game         A gameModel object
     * @param player       The player
     * @param shuffledCard Dealer's card pile
     * @throws GameModel.GameTiedException
     */
    public static void play(GameModel game, Player player,
                            Stack<Integer> shuffledCard)
            throws GameModel.GameTiedException {

        final int DEALER_TOP = 0;   // the dealer's top
        final int PLAYER_TOP = 1;   // the player's top
        final int MESSAGE = 2;      // holds the game result
        final int PICK_NUM = 3;     // how many card to pick
        String[] record;            // holds the information

        record = game.dealCards(shuffledCard, player);

        System.out.printf("%s's turn.\n" +
                        "Top of the stack is %s.\n" +
                        "Your card %s is %s %s\n" +
                        "%s\n", player.getName(), record[DEALER_TOP],
                record[PLAYER_TOP],
                record[MESSAGE], record[DEALER_TOP], record[PICK_NUM]);
    }
}
