package code.wk3_m;

public class LinkedList00 {

    public LinkedList00() {
        head = null;
    }

    //
    public void append(String d) {
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
            while (node.next != null)
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

//    // boolean search()
//    public boolean search(int d) {
//        // 用 node 记录 head 的指向
//        Node node = head;
//
//        // node search到 null 停(注意,不能 search 到倒数第一个停止, 这样子就会漏掉最后一个
//        while (node != null) {
//            if (node.value == d)
//                return true;
//            node = node.next;
//        }
//        return false;
//    }

    private class Node {
        public String value;
        public Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;

    public int countValue(String d) {
        int count = 0;
        if (head == null) {
            return 0;
        } else {
            Node node = head;
            while (node != null && node.value == d) {
                count++;
                node = node.next;
            }
            return count;
        }
    }

    public boolean empty() {
        return head == null;
    }

    public String removeLast() throws Exception {
        String v;
        if (empty()) {
            throw new Exception("Empty");
        } else if (head.next == null) {
            v = head.value;
            head = null;
            return v;
        } else {
            Node p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            v = p.next.value;
            p.next = null;
            return v;
        }
    }

    public String removeLast2() {
        String data = null;
        Node ptr = head;
        Node prev = null;
        if (!empty()) {
            while (ptr.next != null) {
                prev = ptr;
                ptr = ptr.next;
            }
            data = prev.value;
            prev.next = null;
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        LinkedList00 L = new LinkedList00();
        L.append("a");
        L.append("B" +
                "");


        System.out.println(L.removeLast2());
        System.out.println(":" + L);
    }
}
