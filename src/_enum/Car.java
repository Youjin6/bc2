package _enum;

public class Car {

   private CarModel model;

   /**
    * count 必须是 static 的, 在方法造出来之前就得 static
    *
    */
   private static int count;


   Car(){
      if (count % 3 == 0) {
         model = CarModel.JIJI;
      } else if (count % 3 == 1) {
         model = CarModel.TATA;
      } else
         model = CarModel.LALA;
      count++;
   }
   public CarModel getModel() {
      return model;
   }

   enum CarModel{
      TATA, JIJI, LALA
   }

   public static void main(String[] args) {
      final int SIZE = 10;

      CarModel[] values = CarModel.values();
      for (CarModel m : values) {
         System.out.println(m);
      }

      for (int i = 0; i < SIZE; i++) {
         Car car = new Car();
         System.out.println(car.getModel());
      }

   }

}
