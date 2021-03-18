package code.wk4_m;/*
    This program demonstrates how to write and 
    use a stack class based on linked lists.
*/

import java.util.EmptyStackException;
import java.util.Stack;

class LinkedStack {
    /**
     * The Node class is used to implement the
     * linked list.
     */

    private class Node {
        String value;
        Node next;

        Node(String val, Node n) {
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

    public void push(String s) {
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

    public String pop() {
        if (empty())
            throw new EmptyStackException();
        else {
            String retValue = top.value;
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

    public String peek() {
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
            sBuilder.append(p.value);
            p = p.next;
            if (p != null)
                sBuilder.append(" ");
        }
        return sBuilder.toString();
    }

    public Stack<String> copy() {
        Stack<String> stack = new Stack<>();
        Stack<String> help = new Stack<>();
        Node p = top;
        if (top == null) {
        } else {
            while (p != null) {

                stack.push(p.value);
                p = p.next;
            }
            while (!stack.empty()) {
                help.push(stack.pop());
            }
        }
        return help;
    }

    public static void main(String[] args) {
        Stack<String> s;
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("ha");
        linkedStack.push("jj");
        linkedStack.push("jjaa");

//        while (!linkedStack.empty()){
//            System.out.println(linkedStack.pop());
//        }
        System.out.println("----------");
        s = linkedStack.copy();
        while (!s.empty()){
            System.out.println(s.pop());
        }
    }
}