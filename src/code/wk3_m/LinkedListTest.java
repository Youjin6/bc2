package code.wk3_m;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList00 list = new LinkedList00();
        list.append(5);
        list.append(3);
        list.append(7);
        list.append(2);
        list.append(1);
        list.append(-4);
        list.append(17);

        System.out.println("List contains: " + list);
    }
}
