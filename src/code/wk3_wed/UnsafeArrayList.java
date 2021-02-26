package code.wk3_wed;

import java.util.ArrayList;

/**
 * This program demonstrates that an ArrayList can accept
 * a mixture of object types as its elements.
 */

public class UnsafeArrayList {
    public static void main(String[] args) {
        // Create an ArrayList object.
        ArrayList list = new ArrayList();

        // Store a variety of objects in the list.
        list.add("Java is fun!");
        list.add(new Double(2.5));
        list.add(new Rectangle(10, 12));

        // Retrieve a reference to each object in the list.
        // Note that the reference returned from the get
        // method must be cast to the correct type.
        Double d = (Double) list.get(0);
        String s = (String) list.get(1);
        Rectangle r = (Rectangle) list.get(2);
    }
}