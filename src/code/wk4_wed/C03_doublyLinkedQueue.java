package code.wk4_wed;

import java.util.Stack;

public class C03_doublyLinkedQueue {
    class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node front;
    private Node rear;

    // empty
    public boolean empty() {
        return front == null;
    }

    // peek
    public int peek() throws Exception {
        if (empty()) {
            throw new Exception();
        } else {
            return front.value;
        }
    }

    // enqueue
    public void enqueue(int v) {
        if (empty()) {
            rear = new Node(v, null, null);
            front = rear;
        } else {
            rear.next = new Node(v, null, rear);
            rear = rear.next;
        }
    }

    // dequeue
    public int dequeue() throws Exception {
        if (empty()) {
            throw new Exception();
        } else {
            int ans = front.value;
            front = front.next;
            return ans;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("front: " + front + "; ").append("rear: " + rear + "\n");
        Node p = front;
        while (p != null) {
            stringBuilder.append(p.value + " ");
            p = p.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        C03_doublyLinkedQueue doublyLinked = new C03_doublyLinkedQueue();

        doublyLinked.enqueue(1);
        doublyLinked.enqueue(1);
        doublyLinked.enqueue(1);
        doublyLinked.enqueue(1);
        System.out.println(doublyLinked);
        doublyLinked.dequeue();
        doublyLinked.dequeue();
        doublyLinked.dequeue();

        System.out.println(doublyLinked);
    }

}
