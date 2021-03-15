package _enum.rps;

import code.wk3_wed.Rectangle;
import jdk.swing.interop.SwingInterOpUtils;

public class RockPaperScissors {
   private HAND value = HAND.ROCK;
   private static int count = 0;

   public HAND getValue() {
      return value;
   }

   RockPaperScissors(){
      if (count % 3 == 0) {
         value = HAND.ROCK;
      } else if (count % 3 == 1) {
         value = HAND.PAPER;
      } else
         value = HAND.SCISSORS;
      count++;
   }
   public static enum HAND {
      ROCK, PAPER, SCISSORS
   }

   public static void main(String[] args) {
      final int SIZE = 10;

      for (int i = 0; i <= SIZE ; i++) {
         RockPaperScissors rockPaperScissors = new RockPaperScissors();
         System.out.println(rockPaperScissors.getValue());
      }
   }
}
