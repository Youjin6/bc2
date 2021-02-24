package code.wk3_m;

public class LinkedList00 {

    public LinkedList00() {
        head = null;
    }

    //
    public void append(int d) {
        // stack 里面有一个 node 的 reference, 他是 游历的人
        Node node;

        // 判断空指针, head 指向 null
        if (head == null)
            head = new Node(d, null);

        // 若不为空
        else {
            // node 从头开始head 开始找, 扎到最后一个节点)
            // 注意: 不能是最后一个节点的 next 的指向, null就没办法连上串了
            node = head;
            while(node.next != null)
                // node 向后
                node = node.next;

            // 找到最后一个节点了, 把 node.next reference 到一个新的地址.
            node.next = new Node(d, null);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.value + " ");
            node = node.next;
        }
        return sb.toString();
    }

    // boolean search()
    public boolean search(int d) {
        // 用 node 记录 head 的指向
        Node node = head;

        // node search到 null 停(注意,不能 search 到倒数第一个停止, 这样子就会漏掉最后一个
        while (node != null) {
            if (node.value == d)
                return true;
            node = node.next;
        }
        return false;
    }

    private class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;

}
