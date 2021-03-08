package code.wk4_m;

/**
 * This class demonstrates the
 * use of the Stack class.
 */

public class ArrayStackDemo {
    public static void main(String[] arg) {
        String str;  // Use for output
        Stack st = new Stack(5);
        str = "Pushing 10 20 onto the stack.";
        System.out.println(str);
        st.push(10);
        st.push(20);
        str = "Value at top of the stack is ";
        System.out.println(str + st.peek());
        str = "Popping and printing all values:";
        System.out.println(str);
        while (!st.empty())
            System.out.print(st.pop() + " ");
    }
}