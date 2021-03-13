package yli6_lab7;

/**
 * This RenderQueue implements a queue by a doubly linked list
 * @author Youjin Li
 * @version 1.0
 */
public class RenderQueue {
    private Node head;  // head of the linked list
    private Node tail;  // tail of the linked list
    private int size;   // size

    /**
     * Inner class Node
     */
    private class Node {
        RenderCommand value;    // holds the enum string
        Node next;  // holds the next address
        Node prev;  // holds the previous address

        /**
         * Constructor of the Node
         * @param value The enum string
         */
        Node(RenderCommand value) {
            this.value = value;
        }
    }

    /**
     * Constructor of the linked list
     */
    public RenderQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Push into the queue from tail
     * @param renderCommand An enum element
     */
    public void enqueue(RenderCommand renderCommand) {
        // a new Node
        Node cur = new Node(renderCommand);
        if (head == null) {
            head = cur;
        } else {
            tail.next = cur;
            cur.prev = tail;
        }
        tail = cur;
        size++;
    }

    /**
     * Pop from the head of the linked list
     * @return
     */
    public RenderCommand dequeue() {
        // hold the element
        RenderCommand rm = null;
        if (head == null) {
            return rm;
        }
        size--;
        rm = head.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return rm;

    }

    /**
     * Translate the letter to the L-system grammar
     * @param string The input string
     * @return A RenderQueue
     */
    public static RenderQueue fromString(String string) {
        char letter;  // holds each letter

        // Creates a queue
        RenderQueue renderQueue = new RenderQueue();
        for (int i = 0; i < string.length(); i++) {
            letter = string.charAt(i);
            switch (letter) {
                case 'F':
                    renderQueue.enqueue(RenderCommand.FORWARD);
                    break;
                case 'R':
                    renderQueue.enqueue(RenderCommand.FORWARD2);
                    break;
                case 'X':
                    renderQueue.enqueue(RenderCommand.IGNORE);
                    break;
                case '-':
                    renderQueue.enqueue(RenderCommand.RIGHT);
                    break;
                case '+':
                    renderQueue.enqueue(RenderCommand.LEFT);
                    break;
                case '[':
                    renderQueue.enqueue(RenderCommand.PUSH);
                    break;
                case ']':
                    renderQueue.enqueue(RenderCommand.POP);
                    break;
                default:
                    break;
            }
        }
        return renderQueue;
    }


    /**
     * Deep copy the queue
     * @return A RenderQueue object
     */
    public RenderQueue copy() {
        // Creates a new Queue to hold the clone queue
        RenderQueue newQueue = new RenderQueue();
        if (size > 0) {
            newQueue.head = new Node(head.value);
            Node next = head.next;
            Node last = newQueue.head;

            while (next != null) {
                Node newNode = new Node(next.value);
                last.next = newNode;
                last = newNode;
                next = next.next;
            }
        }
        return newQueue;
    }


    /**
     * Appends the copy queue to the current queue
     * @param renderQueue A copy of RenderQueue
     */
    public void append(RenderQueue renderQueue) {
        if (renderQueue != null && head != null) {
            renderQueue.head.prev = tail;
            tail.next = renderQueue.head;
            size += renderQueue.size;
        }
    }

    /**
     * Check if the RenderQueue is empty
     * @return True if empty
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * To show the elements in the queue
     * @return A string builder
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node h = head;
        while (h != null) {
            sb.append(h.value).append(" ");
            h = h.next;
        }
        return sb.toString();
    }

}
