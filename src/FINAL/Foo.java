package FINAL;


public class Foo {
    boolean z;
    int[] t;
    int n(int m) {
        if (!z)
            tt();
        return t[m];
    }

    public  void tt() {
        z = !z;
        t = new int[10000];
        for (int i = 1; i < t.length; i++)
            t[i] = t[i-1] + i;
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
//        int a[];
//        int i = foo.t[5];
//        System.out.println(i);
        foo.n(1);
        System.out.println(foo.t[5]);
    }
}