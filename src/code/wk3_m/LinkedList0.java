package code.wk3_m;

public class LinkedList0 {
    /**
     * The Node class represents a list node.
     */

    // 内部类 Node, 私有,
    // filed: 值,next reference
    private class Node {
        String value;
        Node next;

        /**
         * Constructor.
         *
         * @param val The element to store in this node.
         * @param n   The reference to the next node.
         */

        // 设定双属性构造器
        Node(String val, Node n) {
            value = val;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in this node.
         */
        // 值属性构造器
        Node(String val) {
            value = val;
            next = null;
        }
    }

    //Reference to the first node in the list

    // 在 stack 里造一个 Node, 叫 first
    private Node first = null;

    /**
     * Constructor.
     * Builds a linked list.
     */
	 // 大类: linkedList0
    public LinkedList0() {
        // Incrementally build the list
        // Chuck Debby Elaine Free

        // 类属性是: 几个节点
        // 注意: 一般存放数据的东西有 1. primitive variable 2. 引用变量(可以存放多个属性)
        first = new Node("Debby");
        first.next = new Node("Elaine");
        first.next.next = new Node("Fred");
        first = new Node("Chuck", first);

        String[] names = {"Bob", "Allan"};

        // Use a loop to add all names in the array to the
        // front of the linked list to build the list
        // Allan Bob Chuck Debby Elaine Fred
        for (String s : names)
            first = new Node(s, first);
    }

    /**
     * The print method traverses the list
     * and prints all of its elements.
     */

    // 类方法 print
    public void print() {
        Node ref = first;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }

    /**
     * The main method creates the linked list
     * and invokes its print method.
     */

    public static void main(String[] args) {
        LinkedList0 ll = new LinkedList0();
        String str = "The contents of the list are:";
        System.out.println(str);
        ll.print();
    }
}