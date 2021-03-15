package midterm;

public class George {
   private static int base = 100;
   public int ii, iv;
   private double[] board;

   public George() {
      ii = f();
      iv += ii;
   }

   private int f(int d) {
      board = new double[base + d];
      return base;
   }

   private int f() {
      iv = 2;
      f(iv);
      George.base++;
      return board.length;
   }

   public static void main(String[] args) {
      George x = new George();
      System.out.println(x.iv);
   }
}