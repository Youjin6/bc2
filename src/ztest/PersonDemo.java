package ztest;

public class PersonDemo {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setAge(20);

        Person person2 = new Person();
        person2.setAge(10);

        System.out.println(person1.getAge());
    }
}
