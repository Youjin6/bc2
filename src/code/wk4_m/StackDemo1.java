package code.wk4_m;

import java.util.*;
import java.util.Stack;

/**
    This program demonstrates the java.util.Stack class
*/

public class StackDemo1
{
    public static void main(String [] args)
    {
        // Create a stack of strings and add some names
        Stack<String> stack = new Stack<>();
        String [ ] names = {"Al", "Bob", "Carol"};
        System.out.println("Pushing onto the stack the names:");
        System.out.println("Al Bob Carol");
        for (String s : names)
            stack.push(s);
        
        // Now pop and print everything on the stack
		  String message = "Popping and printing all stack values:";
		  System.out.println(message);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");        
    }    
}
