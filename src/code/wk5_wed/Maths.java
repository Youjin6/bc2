package code.wk5_wed;

public class Maths {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double power(double a, double b) {
        double answer = a;
        for (int i = 2; i <= b; i++)
            answer *= a;
        return answer;
    }
}
