package code.wk4_wed;

import java.util.Stack;

/**
 * This class implements a queue based
 * on linked lists.
 */

public class LinkedQueue {
    int size = 0;

    private class Node {
        int value;
        Node next;

        Node(int val, Node n) {
            value = val;
            next = n;
        }
    }

    private Node front = null;
    private Node rear = null;

    /**
     * The method enqueue adds a value
     * to the queue.
     *
     * @param s The value to be added
     *          to the queue.
     */

    public void enqueue(int s) {
        if (rear != null) {
            size++;
            rear.next = new Node(s, null);
            rear = rear.next;
        } else {
            size++;
            rear = new Node(s, null);
            front = rear;
        }
    }

    /**
     * The empty method checks to see if
     * the queue is empty.
     *
     * @return true if and only if queue
     * is empty.
     */

    public boolean empty() {
        return front == null;
    }

    /**
     * The method peek returns value at the
     * front of the queue.
     *
     * @return item at front of queue.
     * @excepton EmptyQueueException When the
     * queue is empty.
     */

    public int peek() {
        if (empty())
            throw new EmptyQueueException();
        else
            return front.value;
    }

    /**
     * The dequeue method removes and returns
     * the item at the front of the queue.
     *
     * @return item at front of queue.
     * @throws EmptyQueueException When
     *                             the queue is empty.
     */

    public int dequeue() {
        if (empty())
            throw new EmptyQueueException();
        else {
            size--;
            int value = front.value;
            front = front.next;
            if (front == null) rear = null;
            return value;
        }
    }

    public int size() {
        return size;
    }


    /**
     * The toString method concatenates all strings
     * in the queue to give a string representation
     * of the contents of the queue.
     *
     * @return string representation of this queue.
     */
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();

        // Walk down the list and append all values
        Node p = front;
        while (p != null) {
            sBuilder.append(p.value + " ");
            p = p.next;
        }
        return sBuilder.toString();
    }

    // 改成 queue
    public void reverseFirstK(int k, LinkedQueue q) {
        if (k <= 0) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int temp;
        for (int i = 0; i < k; i++) {
            stack.push(q.dequeue());
        }
        while (!stack.empty()) {
            q.enqueue(stack.pop());
        }
        for (int i = 0; i < q.size - k; i++) {
            temp = q.dequeue();
            q.enqueue(temp);
        }
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);
        System.out.println(queue.size);
        queue.reverseFirstK(-3, queue);
        System.out.println(queue);

    }
}