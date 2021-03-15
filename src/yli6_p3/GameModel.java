package yli6_p3;

import java.util.EmptyStackException;
import java.util.Random;

/**
 * @author Youjin Li
 * @version 1.0
 */
public class GameModel {

    Stack<Integer> dealer;      // dealer stack
    Stack<Integer> discard;     // discard stack
    Stack<Integer> shuffledCards; // shuffled cards stack
    Queue<Integer> player1; // player1 queue
    Queue<Integer> player2; // player2 queue

    /**
     * constructor
     */
    GameModel() {
        dealer = new Stack<>();
        discard = new Stack<>();
        player1 = new Queue<>();
        player2 = new Queue<>();
        dealer = genCard();
        shuffledCards = shuffleDeck(dealer);
        distributeCard(shuffledCards);

    }

    /**
     * Generate 52 cards
     *
     * @return 52 cards
     */
    public Stack<Integer> genCard() {
        final int COPY = 4;  // 4 copies
        final int CARD_DECK = 13;  // 13 card a deck
        Stack dealing = new Stack();
        for (int i = 0; i < COPY; i++) {
            for (int j = 1; j <= CARD_DECK; j++) {
                dealing.push(j);
            }
        }
        return dealing;
    }

    /**
     * Shuffles the cards using the Fisher-Yates algorithm
     *
     * @param cards deck to shuffle
     */
    private Stack<Integer> shuffleDeck(Stack cards) {
        Random rand = new Random();
        for (int i = cards.size() - 1; i >= 0; i--) {
            int j = rand.nextInt(i + 1);
            cards.swap(i, j);
        }
        return cards;
    }

    /**
     * Distribute cards to the player1Play at the beginning of the game.
     *
     * @param cards
     */

    public void distributeCard(Stack cards) {
        final int CARD_NUMBER = 7;
        for (int i = 0; i < CARD_NUMBER; i++) {
            player1.enqueue(shuffledCards.pop());
            player2.enqueue(shuffledCards.pop());
        }
    }


    /**
     * Deal card to the player each turn
     *
     * @param shuffledCards The shuffled cards
     * @param player        A player
     * @return A message box
     * @throws GameTiedException When both discard and dealer's pile are empty
     */
    public String[] dealCards(Stack shuffledCards
            , Queue<Integer> player) throws GameTiedException {
        final int CARDS_TWO = 2;   // pick 2 cards
        final int RECORD_NUM = 4;  // length of message array
        final int DEALER_TOP = 0;  // dealer's top
        final int PLAYER_TOP = 1;  // player's top
        final int MESSAGE = 2;     // game result for each turn
        final int PICK_NUM = 3;    // number of cards to pick

        String[] record = new String[RECORD_NUM];

        // Record dealer's top
        try {
            record[DEALER_TOP] = String.valueOf(shuffledCards.peek());
        } catch (EmptyStackException e) {
            turnOver(discard, shuffledCards);
            if (shuffledCards.empty() && discard.empty()) {
                throw new GameTiedException();
            } else {
                record[DEALER_TOP] = String.valueOf(shuffledCards.peek());
            }
        }

        // Record player's top
        record[PLAYER_TOP] = String.valueOf(player.peek());

        // Push player and dealer's top card to the discard pile
        discard.push(player.peek());
        discard.push((Integer) shuffledCards.peek());

        // Player's top less than dealer's
        if ((int) shuffledCards.peek() > player.peek()) {
            shuffledCards.pop();
            for (int i = 0; i < CARDS_TWO; i++) {
                try {
                    player.enqueue((Integer) shuffledCards.pop());
                } catch (EmptyStackException e) {
                    turnOver(discard, shuffledCards);
                    player.enqueue((Integer) shuffledCards.pop());
                }
            }
            record[MESSAGE] = "less than";
            record[PICK_NUM] = "You pick 2 cards.";
            player.dequeue();
        }

        // Player's top equals to dealer's
        else if ((int) shuffledCards.peek() == player.peek()) {
            shuffledCards.pop();
            try {
                player.enqueue((Integer) shuffledCards.pop());
            } catch (EmptyStackException e) {
                turnOver(discard, shuffledCards);
                player.enqueue((Integer) shuffledCards.pop());
            }
            player.dequeue();
            record[MESSAGE] = "equal to ";
            record[PICK_NUM] = "You pick 1 card.";

        }

        // Player's top larger than dealer's top
        else {
            shuffledCards.pop();
            player.dequeue();
            record[MESSAGE] = "larger than";
            record[PICK_NUM] = "good job!";
        }
        return record;
    }

    /**
     * Turn over the Cards
     * @param discard Discard stack
     * @param shuffledCards dealer's card stack
     */
    public void turnOver(Stack<Integer> discard, Stack<Integer> shuffledCards) {
        while (discard.size() != 0) {
            shuffledCards.push(discard.pop());
        }
    }

    /**
     * When both dealer's stack and discard stack are empty
     */
    public class GameTiedException extends Exception {
        /**
         * Constructor
         * @param s A message string
         */
        GameTiedException(String s) {
            System.out.println(s);
        }

        /**
         * Default constructor
         */
        GameTiedException() {
        }
    }
}
