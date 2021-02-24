package code.wk2_f;

public class LinkedList {

    // private Node 内部类
    private class Node {
        String value;
        Node next;

        Node (String value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node (String value) {
            this.value = value;
            next = null;
        }
    }

    // 初始化一个头结点的指向
    private Node first = null; /* 注意初始化一个头节点的写法 */

    public LinkedList() {
        first = new Node("Debby");
        first.next = new Node("Elle");
        first.next.next = new Node("Fred");
        first = new Node("Clark", first);

        String[] names = {"Bob", "Allan"};

        // 用 for 循环吧数组里的元素添加到链表头
        for (String s : names) {
            first = new Node(s,first);
        }
    }

    // 遍历打印
    public void print(){
        Node ref = first;
        while (ref != null) {
            System.out.println(ref.value + " ");
            ref = ref.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        String str = "The contents of the list are: ";
        System.out.println(str);
        linkedList.print();


    }

}
