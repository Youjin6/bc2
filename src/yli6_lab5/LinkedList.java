package yli6_lab5;

/**
 * The LinkedList class implements a Linked list.
 */
public class LinkedList {
    private Node head; // list head

    /**
     * The Node class stores a list element
     * and a reference to the next node.
     */
    private class Node {
        int value;
        Node next;

        /**
         * Constructor.
         *
         * @param value The element to store in the node.
         * @param next  The reference to the successor node.
         */
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        /**
         * Constructor.
         *
         * @param value The element to store in the node.
         */
        public Node(int value) {
            this.value = value;
        }
    }

    public void removeDuplicates() {
        if (head == null || head.next == null)
            return;
        Node cur = head.next;
        Node prev = head;

        // 处理一个重复都没有的情况
//        while ( cur != null) {
//            while (cur != null && prev.value == cur.value) {
//                cur = cur.next;
//            }
//            prev.next = cur;
//            prev =cur;
//            cur = cur.next;
//        }
        while (cur != null ) {
            while (prev.value == cur.value && cur != null) {
                cur = cur.next;
            }
            prev.next = cur;
            prev = cur;
            cur =cur.next;

        }

    }

    /**
     * The insertInOrder method add the integer values to the sequenced linked
     * list.
     *
     * @param value A integer
     */
    public void insertInOrder(int value) {
        // if the linkedList points to null
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

        // More than one node in the linkedList
        Node current = head; // a current node reference
        Node prev = null;    // a previous node reference
        while (current != null && value > current.value) {
            prev = current;
            current = current.next;
        }

        // New element goes at beginning
        if (current == head) {
            head = new Node(value, current);
            return;
        }

        // Add to the second position of list
        if (prev == head) {
            head.next = new Node(value, current);
            return;
        }

        // Add to end of existing list
        if (current == null) {
            prev.next = new Node(value);
        }

        // Add to any other places
        else {
            prev.next = new Node(value, current);
        }
    }

    /**
     * The toString method computes the string
     * representation of the list.
     *
     * @return The string form of the list.
     */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        // User node to walk down the linked list
        Node node = head;
        while (node != null) {
            strBuilder.append(node.value).append("\n");
            node = node.next;
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertInOrder(4);
        list.insertInOrder(5);
        list.insertInOrder(4);
        list.insertInOrder(5);
        list.insertInOrder(0);
        list.insertInOrder(0);
        System.out.println(list);
        list.removeDuplicates();
        System.out.println(list);

    }
}
