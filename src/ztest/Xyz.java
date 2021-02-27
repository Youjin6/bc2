package ztest;

import jdk.swing.interop.SwingInterOpUtils;

public class Xyz {
   private int g;
   private double[] x;
   public Xyz() {
      g = fn();
   }
   private int fn(int d) {
      x = new double[d];
      return this.x.length + 1;
   }
   private int fn() {
      this.g = 4;
      return fn(g);
   }

   public static void main(String[] args) {
      Xyz xyz = new Xyz();
      System.out.println(xyz.g);
      double[] arr = xyz.x;
      for(double a : arr) {
         System.out.println(a);
      }
   }
}