package yli6_lab3;

import java.util.Random;

/**
 * The GuessGame class simulates a guess number game.
 *
 * @author Yucong Li
 * @version 1.0
 */
public class GuessGame {
    private final int rangeMinimum;     // minimum range
    private final int rangeMaximum;     // maximum range
    int target;                     // target number to guess
    int count = 1;                  // initialize a counting variable


    /**
     * Constructor.
     *
     * @param rangeMinimum The minimum range of te target number
     * @param rangeMaximum The maximum range of the target number
     */
    public GuessGame(int rangeMinimum, int rangeMaximum) {
        this.rangeMinimum = rangeMinimum;
        this.rangeMaximum = rangeMaximum;
        newTarget();
    }


    /**
     * Displays number of guesses.
     */
    public void displayStatistics() {
        // Increments the count
        count++;
    }


    /**
     * Randomly chooses a new integer in this game's range which is now the
     * new target.
     */
    public void newTarget() {
        // Creates a Random object
        Random random = new Random();

        // Gets the target number to guess
        target = random.nextInt(getRangeMaximum() - getRangeMinimum() + 1)
                + getRangeMinimum();
    }


    /**
     * Processes the user's guess.
     *
     * @param num The input number from users
     * @return False if number is incorrect, otherwise, returns true
     */
    public boolean guess(int num) {
        boolean guess = false; // A flag
        if (target == num) {
            guess = true;
        } else {
            displayHint(num);
        }

        return guess;
    }


    /**
     * @return The low end of the range used by newTarget
     */
    public int getRangeMinimum() {
        return rangeMinimum;
    }


    /**
     * The high end of the range used by newTarget.
     *
     * @return The Maximum range
     */
    public int getRangeMaximum() {
        return rangeMaximum;
    }


    /**
     * Called from guess function and displays whether the guess was too high or
     * too low.
     *
     * @param num The input number from the user.
     */
    private void displayHint(int num) {
        // Displays the hint message too high or low.
        if (num > target) {
            System.out.println(num + " is too high.");
        } else {
            System.out.println(num + " is too low.");
        }
    }
}
