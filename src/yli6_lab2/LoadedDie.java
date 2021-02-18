package yli6_lab2;

import java.util.Random;

/**
 * The Die class simulates computer's die.
 * 30% of the time the die will roll a 6
 *
 * @author youjin
 * @version 1.0
 */
public class LoadedDie {
    private int loadedNumber;           // The loaded number
    private int moreTimesPerHundred;    // The more times per hundred
    private final int MAX = 99;   // The max number of a die
    private final int MIN = 0;    // The minimum number of a die
    private final int SIDES = 6;   // Number of sides
    private int value;   // The die's value


    /**
     * The constructor performs an initial roll of the die.
     * @param loadedNumber        which number should come up more often
     * @param moreTimesPerHundred how many times per 100 rolls to come up with
     *                            the loaded number (instead of uniform random)
     */
    public LoadedDie(int loadedNumber, int moreTimesPerHundred) {
        this.loadedNumber = loadedNumber;
        this.moreTimesPerHundred = moreTimesPerHundred;

        // Call roll
        value = roll();
    }


    /**
     * The roll method simulates the rolling of the die.
     * It will typically set this die's value to a random value
     * with uniform distribution between 1 and 6. Occasionally,
     * it will a priori return the favored value (with frequency
     * determined by the moreTimesPerHundred argument that was
     * passed to the constructor).
     */
    public int roll() {
        // Create a Random object.
        Random rand = new Random();

        // Get a random value for the die.
        value = rand.nextInt(MAX - MIN + 1);
        if (value < moreTimesPerHundred) {
            value = loadedNumber;
        } else {
            value = rand.nextInt(SIDES) + 1;
        }
        return value;
    }


    /**
     * The getValue method returns the
     * value of the die.
     *
     * @return The value of the die.
     */

    public int getValue() {
        return value;
    }
}