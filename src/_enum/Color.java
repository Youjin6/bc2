package _enum;

@SuppressWarnings("ALL")
enum Color {
   RED, YELLOW, GREEN;

   public static class testClass{
      public static void main(String[] args) {
         Color myColor = Color.GREEN;

         switch (myColor) {
            case RED -> {
               System.out.println("red");
               break;
            }
            case YELLOW -> {
               System.out.println("yellow");
               break;
            }
            case GREEN -> {
               System.out.println("green");
               break;
            }
         }
      }
   }
}

