import code.wk3_wed.Rectangle;
import org.w3c.dom.ls.LSOutput;

public class RockPaperScissors {

   private RPS value;

   public static enum RPS {ROCK, PAPER, SCISSORS}

   RockPaperScissors() {
      value = RPS.ROCK;
      for (RPS r : RPS.values() ) {
         value = r;
      }
   }

   @Override
   public String toString() {
      return "RockPaperScissors{" +
            "value=" + value +
            '}';
   }

   public static void main(String[] args) {
      RockPaperScissors r1 = new RockPaperScissors();
      System.out.println(r1);
      RockPaperScissors r2 = new RockPaperScissors();
      System.out.println(r2);
   }
}
