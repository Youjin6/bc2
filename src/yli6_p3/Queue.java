package yli6_p3;
import java.util.EmptyStackException;

/**
 * A linked list implements queue
 * @param <T> generic type
 */
public class Queue<T> {
    /**
     * Node inner class
     */
    private class Node {
        T value;        // value
        Node next;      // holds next address
        /**
         * Constructor
         * @param val value
         * @param n next address
         */
        Node(T val, Node n) {
            value = val;
            next = n;
        }
    }

    private Node front = null;  // front
    private Node rear = null;   // rear
    private String name;        // name

    /**
     * The enqueue method add element to the linked list
     * @param v value
     */
    public void enqueue(T v) {
        if (rear != null) {
            rear.next = new Node(v, null);
            rear = rear.next;
        } else {
            rear = new Node(v, null);
            front = rear;
        }
    }

    /**
     * The empty method checks to see if the queue is empty.
     *
     * @return true if and only if queue
     * is empty.
     */
    public boolean empty() {
        return front == null;
    }

    /**
     * The method peek returns value at the front of the queue.
     *
     * @return item at front of queue.
     * @excepton Exception When the
     * queue is empty.
     */
    public T peek() throws EmptyStackException {
        if (empty())
            throw new EmptyStackException();
        else
            return front.value;
    }

    /**
     * The dequeue method removes and returns
     * the item at the front of the queue.
     *
     * @return item at front of queue.
     * @throws Exception When
     *                   the queue is empty.
     */
    public T dequeue() throws EmptyStackException{
        if (empty())
            throw new EmptyStackException();
        else {
            T value = front.value;
            front = front.next;
            if (front == null) rear = null;
            return value;
        }
    }

    /**
     * The toString method computes a string
     * representation of the contents of the stack.
     *
     * @return The string representation of the
     * stack contents.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node p = front;
        while (p != null) {
            sb.append(p.value + " ");
            p = p.next;
        }
        return sb.toString();
    }
}

