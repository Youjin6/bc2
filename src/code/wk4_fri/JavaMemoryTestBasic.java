package code.wk4_fri;

public class JavaMemoryTestBasic {

    public static void main(String[] args) {
        int a = 5;
        box1();
    }

    static void box1() {
        int x = 3;
        int x1 = 5;
        box2();
    }

    static void box2() {
        int y = 3;
        int y1 = 4;
        box3();
    }

    static void box3() {
        int z = 4;
        box4();
    }

    static void box4() {
        int b4 = 5;
        System.out.println("Done");
        return;
    }
}
