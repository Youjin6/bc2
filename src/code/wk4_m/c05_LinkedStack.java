package code.wk4_m;

import java.util.EmptyStackException;

public class c05_LinkedStack {

    private class Node {
        public int value;
        public Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node top = null;


    public boolean empty() {
        return top == null;
    }


    // 同时处理了 当 linkedList 是 null 和不是 null 两种
    public void push(int value) {
        top = new Node(value, top);
    }

    public int pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            int retValue = top.value;
            top = top.next;
            return retValue;
        }
    }

    public int peek() {
        if (empty()){
            throw new EmptyStackException();
        } else {
            return top.value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = top;
        while (p != null) {
            sb.append(p.value).append(" ");
            p = p.next;

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        c05_LinkedStack linkedStack = new c05_LinkedStack();
        System.out.println(linkedStack.empty());
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(2);
        linkedStack.push(24);
        System.out.println(linkedStack);

        while (!linkedStack.empty()) {
            linkedStack.pop();
        }

        linkedStack.push(1);
        System.out.println(linkedStack);
    }
}
