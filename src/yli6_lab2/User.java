package yli6_lab2;

/**
 * User class for the DiceGame
 *
 * @author youjin
 * @version 1.0
 */
public class User {
    private int dieValue;  // The value of die

    /**
     * The constructor performs an initial roll of the user
     */
    public User() {
        dieValue = 0; // initializes the die value
    }

    /**
     * Rolls the die
     */
    public void rollDice() {
        // holds the number of loaded number
        final int LOADED_NUMBER = 1;

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
     * The getDieValue method returns a User object's die value.
     * @return The value in the dieValue field.
     */
    public int getDieValue() {
        return dieValue;
    }
}
