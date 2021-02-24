package code.wk3_m;

/**
 * The LinkedList1 class implements a Linked list.
 */

class LinkedList1 {
    /**
     * The Node class stores a list element
     * and a reference to the next node.
     */

    //内部类 Node
    private class Node {
        String value;
        Node next;

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         * @param n   The reference to the successor node.
         */

        Node(String val, Node n) {
            value = val;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         */

        Node(String val) {
            // Call the other (sister) constructor.
            this(val, null);
        }
    }


    // LinkedList00 的 field: 放了两个还未赋值的属性, 都是 node 类型, 一个叫 first 一个叫 last
    private Node first;  // list head
    private Node last;   // last element in list

    /**
     * Constructor.
     */
    // 无参数构造器,可以不写. 因为本身就是 null
    public LinkedList1() {
        first = null;
        last = null;
    }

    /**
     * The isEmpty method checks to see
     * if the list is empty.
     *
     * @return true if list is empty,
     * false otherwise.
     */

    // 判断空方法
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * The size method returns the length of the list.
     *
     * @return The number of elements in the list.
     */

    // size 方法
    /* 要注意这里 count 是从几开始的*/
    public int size() {
        // 计数器
        int count = 0;
        // 新建 p 存放 first 的指向 first指向的, 第一个节点
        Node p = first;

        // p 走到 最后一个进入循环,然后 结束
        while (p != null) {
            // There is an element at p
            count++;
            p = p.next;
        }
        // 看一共 count 了几次
        return count;
    }

    /**
     * The add method adds an element to
     * the end of the list.
     *
     * @param e The value to add to the
     *          end of the list.
     */

    // 尾巴加值
    public void add(String e) {
        // 判空
        if (isEmpty()) {
            //若为空, first 直接指向新节点
            first = new Node(e);
            // head 也是 last
            last = first;
        } else {

            // 若不为空, 则找到 last 节点, last.next 指向新节点
            // Add to end of existing list
            last.next = new Node(e);

            // last 要变成 last.next
            last = last.next;
        }
    }

    /**
     * The add method adds an element at a position.
     *
     * @param e     The element to add to the list.
     * @param index The position at which to add
     *              the element.
     * @throws IndexOutOfBoundsException When
     *                                   index is out of bounds.
     */

    // 在指定位置 add 元素
    public void add(int index, String e) {
        /* 若用户传进来非法位置, 抛异常*/
        if (index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // Index is at least 0
        /* 插在第一个位置 */
        if (index == 0) {
            // New element goes at beginning

            // first 存放新节点, 新节点的下一个值是 first
            first = new Node(e, first);
            /*??????????? 若 last 是 null???????*/
            if (last == null)
                last = first;
            return;
        }

        // Set a reference pred to point to the node that
        // will be the predecessor of the new node
        /*pred 记录头结点的指向*/
        Node pred = first;

        for (int k = 1; k <= index - 1; k++) {
            pred = pred.next;
        }

        // Splice in a node containing the new element
        pred.next = new Node(e, pred.next);

        // Is there a new last element ?
        if (pred.next.next == null)
            last = pred.next;
    }

    /**
     * The toString method computes the string
     * representation of the list.
     *
     * @return The string form of the list.
     */

    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        // Use p to walk down the linked list
        Node p = first;
        while (p != null) {
            strBuilder.append(p.value + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }

    /**
     * The remove method removes the element at an index.
     *
     * @param index The index of the element to remove.
     * @return The element removed.
     * @throws IndexOutOfBoundsException When index is
     *                                   out of bounds.
     */

    public String remove(int index) {
        if (index < 0 || index >= size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        String element;  // The element to return
        if (index == 0) {
            // Removal of first item in the list
            element = first.value;
            first = first.next;
            if (first == null)
                last = null;
        } else {
            // To remove an element other than the first,
            // find the predecessor of the element to
            // be removed.
            Node pred = first;

            // Move pred forward index - 1 times
            for (int k = 1; k <= index - 1; k++)
                pred = pred.next;

            // Store the value to return
            element = pred.next.value;

            // Route link around the node to be removed
            pred.next = pred.next.next;

            // Check if pred is now last
            if (pred.next == null)
                last = pred;
        }
        return element;
    }

    /**
     * The remove method removes an element.
     *
     * @param element The element to remove.
     * @return true if the remove succeeded,
     * false otherwise.
     */

    public boolean remove(String element) {
        if (isEmpty())
            return false;

        if (element.equals(first.value)) {
            // Removal of first item in the list
            first = first.next;
            if (first == null)
                last = null;
            return true;
        }

        // Find the predecessor of the element to remove
        Node pred = first;
        while (pred.next != null &&
                !pred.next.value.equals(element)) {
            pred = pred.next;
        }

        // pred.next == null OR pred.next.value is element
        if (pred.next == null)
            return false;

        // pred.next.value  is element
        pred.next = pred.next.next;

        // Check if pred is now last
        if (pred.next == null)
            last = pred;

        return true;
    }

    public static void main(String[] args) {
        LinkedList1 ll = new LinkedList1();
        ll.add("Amy");
        ll.add("Bob");
        ll.add(0, "Al");
        ll.add(2, "Beth");
        ll.add(4, "Carol");
        System.out.println("The members of the list are:");
        System.out.print(ll);
    }
}