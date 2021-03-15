package midterm;

public class test {
   public static boolean isRed(Suit card) {
      boolean flag = false;
      if (card == Suit.DIAMONDS || card == Suit.HEARTS) {
         flag = true;
      }
      return flag;
   }

   public static boolean isBlack(Suit card) {
      return !isRed(card);
   }

}
