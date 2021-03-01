package code.wk4_m;

public class c04_ArrayStackDeome {
    public static void main(String[] args) {
        c03_ArrayStack s = new c03_ArrayStack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);

        System.out.println(s.peek());
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }

        System.out.println(s.peek());
    }
}
