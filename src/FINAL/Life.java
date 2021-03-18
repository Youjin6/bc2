package FINAL;

import java.util.EmptyStackException;
import java.util.IllegalFormatException;

public class Life {

    private Node top = null;

    private class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Life() {

    }


    public void push(int n) {
        try {
            if (n <= 0) {
                throw new IllegalArgumentException();
            }
            top = new Node(n, top);
        } catch (IllegalFormatException e) {
            System.out.println("Please enter a numeric numeric integer!");
        }
    }

    public boolean empty() {
        return top == null;
    }

    public int peek() {
        if (empty())
            throw new EmptyStackException();
        else
            return top.value;
    }

    public int pop() {
        if (empty())
            throw new EmptyStackException();
        else {
            int retValue = top.value;
            top = top.next;
            return retValue;
        }
    }

    public static void main(String[] args) {
        Life life = new Life();
        life.push(1);
        life.push(2);

        life.pop();
    }


}
