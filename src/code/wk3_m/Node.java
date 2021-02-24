package code.wk3_m;

public class Node {
    String value;
    Node next; // 一个地址
    Node prev; // 另一个地址

    Node(String value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    Node(String value) {
        this(value, null, null);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
