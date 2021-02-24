package code.wk3_m;

public class test {
    public static void main(String[] args) {
        String value;
        Node node = new Node("MAMA");
        Node node2 = new Node("BABA");
        value = node.value;
        System.out.println(value);
        System.out.println(node);

        value = node2.value;
        System.out.println(value);
        System.out.println(node2);
        System.out.println("---node3---");

        Node node3 = new Node("CONGCONG", node, node2);
        System.out.println(node3);
        System.out.println(node3.value);
        System.out.println(node3.next.value);
        System.out.println(node3.prev.value);
    }

}
