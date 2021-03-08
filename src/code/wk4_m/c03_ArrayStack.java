package code.wk4_m;

import java.util.Arrays;
import java.util.EmptyStackException;

public class c03_ArrayStack {
    private int[] stack;
    private int top;

    // 构造器传入 array 的 capacity
    public c03_ArrayStack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    // empty
    public boolean empty() {
        return top == -1;
    }

    // push
    public void push(int x) {
        if (top == stack.length) {
            throw new StackOverflowError();
        } else {
            top++;
            stack[top] = x;
        }
    }

    // pop
    public int pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            int val = stack[top];
            top--;
            return val;

        }
    }

    // peek
    public int peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return stack[top];
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + Arrays.toString(stack) +
                ", top=" + top +
                '}';
    }

    public static void main(String[] args) {
        c03_ArrayStack stack = new c03_ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack);
    }

}
