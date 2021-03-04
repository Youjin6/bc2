package ztest;

public class Person {
   private String name;
   private int age;
   private int count;

   Person(int number) {
   }
   public void eatChina() {
      System.out.println(name + " is eating ....in  China(name)");
      eatKorea(name);
   }

   public void eatKorea(String name) {

      System.out.println(name + " is eating in Korea...(name)");
      System.out.println(this.name + "is eating in China(this.name)");
      eatChina();
   }


   public Person(String name, int age) {
      this(name);
      this.age = age;
   }
   public Person(String name) {
      this.name = name;
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

   @Override
   public String toString() {
      return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
   }
}
