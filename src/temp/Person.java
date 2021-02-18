package temp;

public class Person {
    public static String name;
    public int age;

    public static void eat() {
        System.out.println("static eat() ....");
        new Person().look();
    }

    public void look() {
        System.out.println("no static...");
    }

    public void run(){
        System.out.println("run() non static..");
        Person.eat();
        eat();
    }

    public static void main(String[] args) {
        Person youjin = new Person();

        Person.eat();
//        youjin.look();
        eat();
        String name = Person.name;


    }
}
