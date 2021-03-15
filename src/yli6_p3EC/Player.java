package yli6_p3EC;

/**
 * Player
 */
public class Player {
    private String name;            // holds the name
    private Queue<Integer> queue = new Queue<>();   // cards queue

    /**
     * Constructor
     * @param name A player name
     */
    Player(String name) {
        this.name = name;
    }

    /**
     * Gets player's name
     * @return A name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets player's name
     * @param name A name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the card queue
     * @return A card queue
     */
    public Queue<Integer> getQueue() {
        return queue;
    }

    /**
     * Sets the card queue
     * @param queue A card queue
     */
    public void setQueue(Queue<Integer> queue) {
        this.queue = queue;
    }
}
