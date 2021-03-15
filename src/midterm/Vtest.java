package midterm;

import jdk.swing.interop.SwingInterOpUtils;

public class Vtest {
   public static void main(String[] args) {
      Volume V1 = new Volume(1, 2, 3);
      System.out.println(V1);
      V1.rotate();
      System.out.println(V1);
      System.out.println(V1.getTotalVolume());

      Volume V2 = new Volume(1, 1, 10);
      System.out.println(V2);
      System.out.println(V2.getTotalVolume());
   }
}
