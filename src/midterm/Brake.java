package midterm;

/**
 * This Brake simulates a brake
 * @author Youjin Li
 * @version 1.0
 */
public class Brake {
   private boolean isLeft;   // holds is left brake
   private boolean isFront; // holds is front brake
   private static double pressure = 0;  // holds the initial value of pressure

   /**
    * Constructor
    * @param isLeft True if is left brake
    * @param isFront True if is front brake
    */
   public Brake(boolean isLeft, boolean isFront) {
      this.isLeft = isLeft;
      this.isFront = isFront;
   }

   /**
    * Apply pressure to the brake
    * @param pressureChange The change of the pressure
    */
   public void apply(double pressureChange) {
      pressure += pressureChange;
   }

   /**
    * Prints out the the status of the brake
    */
   public void release() {
      if (isReleased()) {
         System.out.print("(Released): ");
      } else {
         System.out.printf("(Pressure: %.2f kPa): ", getPressure());
      }
   }

   /**
    * Get the current value of the pressure
    * @return The pressure
    */
   public double getPressure() {
      if (pressure <= 0) {
         return pressure = 0;
      }
      return pressure;
   }

   /**
    * If the brake is now released
    * @return True if released
    */
   public boolean isReleased() {
      boolean flag = false;  // holds the flag
      if (getPressure() == 0) {
         flag = true;
      }
      return flag;
   }

   /**
    * Prints out the current status of the Brake instance.
    * @return A string to describe the current status.
    */
   @Override
   public String toString() {
      final String DRIVER = "Driver";   // driver
      final String PASSENGER = "Passenger"; // passenger
      final String FRONT = "front"; // front
      final String REAR = "rear"; // rear

      StringBuilder sb = new StringBuilder();
      if (isFront && isLeft) {
         sb.append(DRIVER + "'s " + FRONT + " brake");
      }
      if (isFront && !isLeft) {
         sb.append(PASSENGER + "'s " + FRONT + " brake");
      }
      if (!isFront && isLeft) {
         sb.append(DRIVER + "'s " + REAR + " brake");
      }
      if(!isFront && !isLeft) {
         sb.append(PASSENGER + "'s " + REAR + " brake");
      }

      // Call release
      release();

      return sb.toString();
   }
}
