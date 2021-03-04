package ztest;

import java.util.ArrayList;

public class PersonDemo {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            people.add(new Person(i));
        }

        System.out.println(people);
    }
}
