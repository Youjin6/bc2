package ztest;

public class PersonDemo {
    public static void main(String[] args) {
        Person person1 = new Person("Y", 18);
        System.out.println("---------PRINT EAT METHOD--------------");
        person1.eatChina();
        System.out.println();

        System.out.println("---------PRINT EAT KOREA---------");
        person1.eatKorea("长");


    }
}
