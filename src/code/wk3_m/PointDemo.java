package code.wk3_m;

public class PointDemo {

    public static void main(String[] args) {
        double distance;
        Point point1 = new Point(1,2);
        Point point2 = new Point(2.3, 43);
        System.out.println(point1);
        System.out.println(point2);
        distance = point1.CalDistance(point1,point2);
        System.out.println(distance);
    }



}
