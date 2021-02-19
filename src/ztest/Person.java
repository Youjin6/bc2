package ztest;

public class Person {
    private String name;
    private int age;

    public void eat() {
        System.out.println("static eat() ....");

    }

    public void look() {
        System.out.println("no static...");
    }

    public void run(){
        System.out.println("run() non static..");

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
