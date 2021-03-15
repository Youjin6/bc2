package yli6_p3EC;

import java.util.EmptyStackException;

/**
 * A linked list implements Stack
 * @param <T> Genetic type
 * @author Youjin Li
 * @version 1.0
 */
public class Stack<T> {
    /**
     * The Node class is used to implement the
     * linked list.
     */
    private class Node {
        T value;
        Node next;

        /**
         * Constructor
         *
         * @param val value
         * @param n   holds next address
         */
        Node(T val, Node n) {
            value = val;
            next = n;
        }
    }

    private Node top = null;  // Top of the stack

    /**
     * The empty method checks for an empty stack.
     *
     * @return true if stack is empty, false otherwise.
     */
    public boolean empty() {
        return top == null;
    }

    /**
     * The push method adds a new item to the stack.
     *
     * @param s The item to be pushed onto the stack.
     */
    public void push(T s) {
        top = new Node(s, top);
    }

    /**
     * The Pop method removes the value at the
     * top of the stack.
     *
     * @return The value at the top of the stack.
     * @throws EmptyStackException When the
     *                             stack is empty.
     */
    public T pop() {
        if (empty())
            throw new EmptyStackException();
        else {
            T retValue = top.value;
            top = top.next;
            return retValue;
        }
    }

    /**
     * The peek method returns the top value
     * on the stack.
     *
     * @return The value at the top of the stack.
     * @throws EmptyStackException When the
     *                             stack is empty.
     */
    public T peek() {
        if (empty())
            throw new EmptyStackException();
        else
            return top.value;
    }

    /**
     * The toString method computes a string
     * representation of the contents of the stack.
     *
     * @return The string representation of the
     * stack contents.
     */
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        Node p = top;
        while (p != null) {
            sBuilder.append(p.value).append(" ");
            p = p.next;
        }
        return sBuilder.toString();
    }

    /**
     * The size method compute the size of the linked list
     *
     * @return The size of the linked list
     */
    public int size() {
        int count = 0;
        Node p = top;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * Swap the value between two nodes
     *
     * @param i First node
     * @param j Second node
     */
    public void swap(int i, int j) {
        Node p = top;
        Node p1 = top;
        int countI = 0;
        int countJ = 0;
        while (countI != i) {
            p = p.next;
            countI++;
        }
        while (countJ != j) {
            p1 = p1.next;
            countJ++;
        }
        T temp = p.value;
        p.value = p1.value;
        p1.value = temp;
    }
}
