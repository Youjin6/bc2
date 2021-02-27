package midterm_prep;

public class Point {
   private double x;
   private double y;

   public Point(double xCoord, double yCoord) {
      x = xCoord;
      y = yCoord;
   }

   public double getX() {
      return x;
   }

   public double getY() {
      return y;
   }

   public void setX(double xCoord) {
      x = xCoord;
   }

   public void setY(double yCoord) {
      y = yCoord;
   }

   public static Point makeDirection(Compass direction) {
      switch (direction) {
         case NORTH:
            return new Point(0, 1);
         case EAST:
            return new Point(0,1);
         default:
            return new Point(0,0);
      }
   }
}