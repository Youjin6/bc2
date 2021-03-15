package midterm_prep;

public class Cat {
   private String color;
   private int age;

   Cat(String color, int age) {
      this.color = color;
      this.age = age;
   }

   @Override
   public String toString() {
      return "Cat{" +
            "color='" + color + '\'' +
            ", age=" + age +
            '}';
   }
}
