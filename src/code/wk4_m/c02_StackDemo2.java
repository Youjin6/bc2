package code.wk4_m;

import java.util.Stack;

public class c02_StackDemo2 {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();

        for (int i = 1; i <= 10; i++) {
            System.out.println(intStack.push(i * i));
        }
        System.out.println(intStack);

        while (!intStack.empty()) {
            System.out.println(intStack.pop()
            );
        }
    }
}
