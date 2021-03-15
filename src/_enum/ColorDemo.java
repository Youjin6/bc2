package _enum;

public class ColorDemo {
   public static void main(String[] args) {
      for(Color c : Color.values()) {
         System.out.println(c);
      }

      Color arr[] = Color.values();
      for (Color c : arr){
         System.out.println(c);
         int ordinal = c.ordinal();
         System.out.println(ordinal);
      }


   }
}
