package code.wk3_wed;

import jdk.swing.interop.SwingInterOpUtils;

public class RectangleTest {
   public static void main(String[] args) {
      Rectangle<Double> doubleRectangle = new Rectangle<Double>(10.0,15.0);
      System.out.println(doubleRectangle);

      Rectangle<Integer> integerRectangle = new Rectangle<Integer>(105,20);
      System.out.println(integerRectangle);

   }
}
