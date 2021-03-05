package yli6_P2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This MessageDecoder implements a secret message decoder.
 *
 * @author Yucong Li
 * @version 1.0
 */
public class MessageDecoder {
    private Node head; // list head

    /**
     * The Node class stores a list element, value
     * and a reference to the next node.
     */
    static class Node {
        char character;
        int value;
        Node next;

        /**
         * Constructor
         *
         * @param character The letter to store in the node.
         * @param value     The number to store in the node.
         * @param next      The reference to the successor node.
         */
        public Node(char character, int value, Node next) {
            this.character = character;
            this.value = value;
            this.next = next;
        }

        /**
         * Constructor.
         *
         * @param character The letter to store in the node.
         * @param value     The number to store in the node.
         */
        public Node(char character, int value) {
            this.character = character;
            this.value = value;
        }
    }

    /**
     * The toString method computes the string
     * representation of the decode message.
     *
     * @return The string form of the list.
     */
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        // Use node to walk down the linked list
        Node node = head;
        while (node != null) {
            strBuilder.append(node.character);
            node = node.next;
        }
        return strBuilder.toString();
    }

    /**
     * Get a plain text message from the file
     * @param filename A filename
     * @return The filename
     * @throws FileNotFoundException File not found
     */
    public String getPlainTextMessage(String filename) throws FileNotFoundException {

        StringBuilder contents = new StringBuilder();

        // Reads the file
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()) {
            contents.append(inputFile.nextLine());
            contents.append("\n");
        }

        // Close the Scanner
        inputFile.close();
        return contents.toString();
    }

    /**
     * Insert the nodes to the linked list by order
     * @param letter The character
     * @param value  The number
     */
    public void insertInOrder(char letter, int value) {
        if (head == null) {
            head = new Node(letter, value);
            return;
        }
        // just one node in the linkedList
        if (head.next == null) {
            if (value >= head.value)
                head.next = new Node(letter, value);
            else
                head = new Node(letter, value, head);
            return;
        }

        // More than one node in the linkedList
        Node current = head; // a current node reference
        Node prev = null;    // a previous node reference
        while (current != null && value > current.value) {
            prev = current;
            current = current.next;
        }
        if (current == head) {
            head = new Node(letter, value, current);
            return;
        }
        if (prev == head) {
            head.next = new Node(letter, value, current);
            return;
        }
        if (current == null)
            prev.next = new Node(letter, value);
        else
            prev.next = new Node(letter, value, current);
    }
}
