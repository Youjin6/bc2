package code.wk3_m;

public class Point {
    double x;
    double y;
    double distance;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", distance=" + distance +
                '}';
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double CalDistance(Point point1, Point point2) {
        distance =
                Math.sqrt(Math.pow(point1.x - point2.x, 2)
                        + Math.pow((point1.y - point2.y), 2));
        return distance;
    }
}
