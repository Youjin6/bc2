package code.yli6_lab4;

public class LinkedList {
    private Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }
    }


    public void insertInOrder(int value) {
        // if the linkedList has no node
        if (head == null) {
            head = new Node(value);
            return;
        }

        // just one node in the linkedList
        if (head.next == null) {
            if (value >= head.value) {
                head.next = new Node(value);
            } else {
                head = new Node(value, head);
            }
            return;
        }

        // more than one node in the linkedList
        Node current = head;
        Node prev = null;
        while (current != null && value > current.value) {
            prev = current;
            current = current.next;
        }

        // add the node to the first position
        if (current == head) {
            head = new Node(value,current);
            return;
        }

        // add the node to the second position
        if (prev == head) {
            head.next = new Node(value,current);
            return;
        }

        // add the node to the very end place
        if (current == null) {
            prev.next = new Node(value);
        }

        // add the node in any other places
        else {
            prev.next = new Node(value,current);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.value + " ");
            node = node.next;
        }
        return sb.toString();
    }
}
