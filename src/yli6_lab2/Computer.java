package yli6_lab2;

/**
 * Computer class for the DiceGame
 *
 * @author youjin
 * @versin 1.0
 */
public class Computer {
    private int dieValue;  // The value of die

    /**
     * The constructor performs an initial roll of the computer.
     */
    public Computer() {
        dieValue = 0;    // initialize the value of die
    }

    public void rollDice() {
        // holds the number of loaded number
        final int LOADED_NUMBER = 6;

        // holds the how many times per 100 rolls to come up with the loaded
        // number (instead of uniform random)
        final int MORE_TIMES_PER_HUNDRED = 30;

        // Create the a die.
        LoadedDie loadedDie = new LoadedDie(LOADED_NUMBER,
                MORE_TIMES_PER_HUNDRED);

        // Record their values.
        dieValue = loadedDie.getValue();
    }

    /**
     * The getDieValue method returns a Computer object's die value.
     *
     * @return The value in the dieValue field.
     */
    public int getDieValue() {
        return dieValue;
    }
}
