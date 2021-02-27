package code.wk3_m;

public class Point {
   double x;
   double y;

   public Point(double x, double y) {
       this.x = x;
       this.y = y;
   }

   public double calcDistance(Point p) {
       return Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
   }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
