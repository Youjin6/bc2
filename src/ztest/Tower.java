package ztest;

import java.util.ArrayList;

public class Tower {

    private ArrayList<Integer> stack;

    Tower() {
        stack = new ArrayList<>();
    }

    public void push(int n) {
        if (empty()) {
            stack.add(0, n);
        } else if (n <= stack.get(stack.size() - 1)) {
            stack.add(stack.size(), n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    public int peek() {
        if (empty()) {
            throw new IllegalArgumentException();
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    public int depth() {
        return stack.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = depth() - 1; i >= 0; i--) {
            sb.append(stack.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.push(3);
        tower.push(2);
        tower.push(1);
        System.out.println(tower);
    }
}
