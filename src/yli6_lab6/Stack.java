package yli6_lab6;

import java.util.EmptyStackException;

/**
 * Array Implementation of a stack.
 * @author youjin
 * @version 1.0
 */

public class Stack {
    private double[] s;  // Holds stack elements
    private int top;   // Stack top pointer
    final int CAPACITY = 10;

    /**
     * Constructor.
     */

    public Stack() {
        s = new double[CAPACITY];
        top = 0;
    }

    /**
     * The empty method checks for an empty stack.
     *
     * @return true if stack is empty.
     */

    public boolean empty() {
        return top == 0;
    }

    /**
     * The push method pushes a value onto the stack.
     *
     * @param x The value to push onto the stack.
     * @throws StackOverflowError When the
     *                            stack is full.
     */

    public void push(double x) {
        if (top == s.length)
            throw new StackOverflowError();
        else {
            s[top] = x;
            top++;
        }
    }

    /**
     * The pop method pops a value off the stack.
     *
     * @return The value popped.
     * @throws EmptyStackException When the
     *                             stack is empty.
     */

    public double pop() {
        if (empty())
            throw new EmptyStackException();
        else {
            top--;
            return s[top];
        }
    }

    /**
     * The peek method returns the value at the
     * top of the stack.
     *
     * @return value at top of the stack.
     * @throws EmptyStackException When the
     *                             stack is empty.
     */

    double peek() {
        if (empty())
            throw new EmptyStackException();
        else {
            return s[top - 1];
        }
    }

    /**
     * Return the size of the stack
     * @return Top
     */
    int size(){
        return top;
    }

}