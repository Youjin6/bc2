package code.wk4_m;

import java.util.Stack;

public class c01_StackDemo1 {
    public static void main(String[] args) {
        // new 一个栈
        Stack<String> stack = new Stack<>();

        // new 一个数组
        String[] names = {"a", "b", "cc"};

        // 入栈
        for (String name : names) {
            System.out.println(name);
            stack.push(name);
        }

        // 打印栈 (以数组形式, 不用 toString)
        System.out.println(stack);

        // 出栈
        while (!stack.empty())
            System.out.println(stack.pop() + " ");


        System.out.println(
        );

        int num = Integer.parseInt("1");
        double numD = Double.parseDouble("22");
        byte b = Byte.parseByte("3");


    }
}
