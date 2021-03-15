package midterm_prep;

public class Rectangle {
   private int height;
   private int width;

   // 注意这里 她很喜欢 设置一个 static 的 counter
   private static int totalArea = 0;

   public Rectangle(int height, int width) {
      this.height = height;
      this.width = width;
      // totalArea 累加area的返回值.
      totalArea += area();
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("height is: " + height);
      sb.append("width is: " + width);

      // 注意: 返回sb.toString
      return sb.toString();
   }

   public int area() {
      return height * width;
   }


   public int getTotalArea() {
      return totalArea;
   }

   public static void main(String[] args) {
      Rectangle r1 = new Rectangle(1, 2);
      int area = r1.area();
      System.out.println(area);
      System.out.println(r1.getTotalArea());
      Rectangle r2 = new Rectangle(2, 3);

      int t2 = r2.getTotalArea();
      System.out.println(t2);
   }
}
