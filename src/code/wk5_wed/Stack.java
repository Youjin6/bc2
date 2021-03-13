package code.wk5_wed;

import java.util.EmptyStackException;

/**
 * Array Implementation of a stack.
 */
public class Stack {
    private String[] s;  // Holds stack elements
    private int top;   // Stack top pointer

    /**
     * Constructor.
     *
     * @param capacity The capacity of the stack.
     */
    public Stack(int capacity) {
        s = new String[capacity];
        top = -1;
    }

    /**
     * The empty method checks for an empty stack.
     *
     * @return true if stack is empty.
     */
    public boolean empty() {
        return top == -1;
    }

    /**
     * The push method pushes a value onto the stack.
     *
     * @param x The value to push onto the stack.
     */
    public void push(String x) {
        if (top == s.length - 1)
            resize();

        top++;
        s[top] = x;
    }

    /**
     * The pop method pops a value off the stack.
     *
     * @return The value popped.
     * @throws EmptyStackException When the stack is empty.
     */
    public String pop() {
        if (empty())
            throw new EmptyStackException();
        else {
            String val = s[top];
            top--;
            return val;
        }
    }

    /**
     * The peek method returns the value at the top of the stack.
     *
     * @return value at top of the stack.
     * @throws EmptyStackException When the stack is empty.
     */
    public String peek() {
        if (empty())
            throw new EmptyStackException();
        else
            return s[top];
    }

    /**
     * The size method returns the number of items in the queue.
     *
     * @return
     */
    public int size() {
        return top + 1;
    }

    /**
     * The resize method doubles the capacity of the stack.
     */
    private void resize() {
        String[] temp = new String[s.length * 2];
        for (int i = 0; i < s.length; i++)
            temp[i] = s[i];
        s = temp;
    }
}