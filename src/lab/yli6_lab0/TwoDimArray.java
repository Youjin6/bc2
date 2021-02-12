package lab.yli6_lab0;

import java.util.Random;
import java.util.Scanner;

/**
 * @author youjin
 * @version 1.0
 */
public class TwoDimArray {
   public static void main(String[] args) {
      printIntro();
      run();
      printGoodbye();

   }

   public static void printIntro() {
      System.out.println("This program asks for the size of a 2d square " +
            "array of integers, then \ncreates the square array," +
            " fills it with random numbers, then prints it \n" +
            "out along with sums in both directions and along the diagonals" +
            ".");
   }

   public static void printGoodbye(){
      System.out.println("\nThanks for playing TwoDimArray!");
   }

   public static int getInput() {

      int number;
      Scanner keyboard = new Scanner(System.in);

      System.out.print("\nHow many rows (something between 1 and 10)? ");
      number = keyboard.nextInt();
      return number;
   }

   public static void showArray(int number) {
      final int MIN = 1;
      final int MAX = 100;
      int sumRow;
      int sumCol;
      int leftDiagonal;
      int rightDiagonal;
      int[][] twoDimArray = new int[number][number];
      Random random = new Random();

      // Populates and displays the 2D array and calculates the sum of each row
      for (int i = 0; i < twoDimArray.length; i++) {

         // Prints space
         System.out.print("     ");

         // Initialize the sum of each row
         sumRow = 0;

         // Populates values for the 2D array
         for (int j = 0; j < twoDimArray[i].length; j++) {
            int value = random.nextInt(MAX - MIN + 1);
            twoDimArray[i][j] = value;
            // Sum each row in the 2D array
            sumRow += value;

            // Displays each value
            System.out.printf("%5d", value);
         }

         // Displays the sum of each row
         System.out.printf(" = %5d", sumRow);
         System.out.println();
      }


      // Initialize the sum of left diagonal
      leftDiagonal = 0;

      // Calculates the sum of the left diagonal
      for (int row = 0; row < twoDimArray.length; row++) {
         leftDiagonal += twoDimArray[row][number - 1 - row];
      }
      System.out.printf("%5d", leftDiagonal);





      // Calculates the sum of each column
      for (int col = 0; col < twoDimArray[0].length; col++) {
         // Initializes the sum of each column
         sumCol = 0;
         for (int row = 0; row < twoDimArray.length; row++) {
            sumCol += twoDimArray[row][col];
         }
         System.out.printf("%5d", sumCol);
      }


      // Initialize the sum of left diagonal
      rightDiagonal = 0;

      // Calculates the sum of the right diagonal
      for (int row = 0; row < twoDimArray.length; row++) {
         rightDiagonal += twoDimArray[row][row];
      }
      System.out.printf("   %5d\n", rightDiagonal);
   }

   public static void run(){
      String repeat;
      Scanner keyboard = new Scanner(System.in);
      do {
         showArray(getInput());
         System.out.print("\nGo again? ");
         repeat = keyboard.nextLine();
      } while (repeat.equalsIgnoreCase("y"));
   }

}
