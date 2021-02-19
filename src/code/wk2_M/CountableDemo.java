package code.wk2_M;

public class CountableDemo {
    public static void main(String[] args) {
        Countable c1 = new Countable();
        int count = c1.getInstanceCount();
        System.out.println(count);

        Countable c2 = new Countable();
        System.out.println(c2.getInstanceCount());

        int instanceCount = Countable.instanceCount;
        System.out.println(instanceCount);
    }


}
