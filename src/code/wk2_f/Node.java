package code.wk2_f;

public class Node {
    String value;
    Node next;

    // constructor, 两个参数, value, Node, 为了从某个 Node 的前面添加节点
    Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }


    // constructor, 我的 next 后面还没节点
    Node(String value) {
        this.value = value;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        Node myList = new Node("youjin");
        myList.next = new Node("shaohang");
        System.out.println(myList);

        // head insert
        Node family = new Node("family", myList);
        System.out.println(family);

        // insert dog
        myList.next = new Node("dog", myList.next);
        System.out.println(family);

        // remove dog
        myList.next = myList.next.next;
        System.out.println(family);
    }
}
