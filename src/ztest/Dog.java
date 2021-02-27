package ztest;

public class Dog {
   private String breed;
   private double weight;
   private boolean female;

   public Dog(boolean female) {
      this.female = female;
      weight = 0.0;
      breed = ""; /* 注意这个不是null*/
   }

   public String getBreed() {
      return breed;
   }

   public void setBreed(String breed) {
      this.breed = breed;
   }

   public double getWeight() {
      return weight;
   }

   public void setWeight(double weight) {
      this.weight = weight;
   }

   public boolean isFemale() {
      return female;
   }

   public boolean isMale(boolean female) {
      return !isFemale();
   }
}
