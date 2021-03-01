package yli6_lab5;

/**
 * The LinkedList class implements a Linked list.
 *
 * @author Youjin Li
 * @version 1.0
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

   /**
    * Removes the duplicated values in the list
    */
   public void removeDuplicates() {
      if (head == null || head.next == null) {
         return;
      }

      Node cur = head.next; // current value
      Node prev = head;     // previous value

      while (cur != null) {
         while (cur != null && prev.value == cur.value) {
            cur = cur.next;
         }
         if (cur != null) {
            prev.next = cur;
            prev = cur;
            cur = cur.next;
         } else {
            prev.next = null;
         }
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
         if (value >= head.value)
            head.next = new Node(value);
          else
            head = new Node(value, head);
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
         head = new Node(value, current);
         return;
      }
      if (prev == head) {
         head.next = new Node(value, current);
         return;
      }
      if (current == null)
         prev.next = new Node(value);
      else
         prev.next = new Node(value, current);
   }

   /**
    * The toString method computes the string
    * representation of the list.
    *
    * @return The string form of the list.
    */
   @Override
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
}
