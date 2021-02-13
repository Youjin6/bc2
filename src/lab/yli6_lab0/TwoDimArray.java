package lab.yli6_lab0;

import java.util.Random;
import java.util.Scanner;

/**
 * This TwoDimArray program implements an application that creates a
 * two-dimensional array of integers according to the user's request and
 * print the array contents along with the sum of each each row,
 * column and major diagonals.
 *
 * @author youjin
 * @version 1.0
 */
public class TwoDimArray {
   /**
    * Tests the whole program.
    *
    * @param args A string array containing the command line arguments.
    */
   public static void main(String[] args) {
      // Creat an Scanner object
      Scanner keyboard = new Scanner(System.in);

      // Call printIntro method
      printIntro();

      // Call run method
      run(keyboard);

      // Call printGoodbye
      printGoodbye();

      // Close Scanner
      keyboard.close();
   }


   /**
    * Prints out the introduction of the game.
    */
   public static void printIntro() {
      System.out.println("This program asks for the size of a 2d square " +
            "array of integers, then \ncreates the square array," +
            " fills it with random numbers, then prints it \n" +
            "out along with sums in both directions and along the diagonals" +
            ".\n");
   }


   /**
    * Prints out the goodbye message to the standard output.
    */
   public static void printGoodbye(){
      System.out.println("\nThanks for playing TwoDimArray!");
   }


   /**
    * Ask users for the number of rows for the array.
    *
    * @param keyboard A Scanner
    * @return The input number
    */
   public static int getInput(Scanner keyboard) {
      int number;  // holds the input number from the users
      final int MAX_NUMBER = 10; // holds the limit number

      // Prompts users for a number from 1 to 10
      do {
         System.out.print("How many rows (something between 1 and 10)? ");
         number = keyboard.nextInt();
         keyboard.nextLine();
      } while (number > MAX_NUMBER);

      return number;
   }


   /**
    * Displays the array contents along with the sum of each each row,
    * column and major diagonals.
    *
    * @param number Input number from the users
    */
   public static void showTwoDimArray(int number) {
      final int MIN = 1;      // Min value
      final int MAX = 100;    // Maximum value
      int sumRow;             // Sum of each row
      int sumCol;             // Sum of each column
      int leftDiagonal;       // Sum of the left Diagonal
      int rightDiagonal;      // Sum of the right Diagonal

      // Creat a 2D array
      int[][] twoDimArray = new int[number][number];

      // Creat a Random object
      Random random = new Random();

      System.out.println();

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
         for (int[] ints : twoDimArray) {
            sumCol += ints[col];
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

   /**
    * Runs the program as many time as the users want
    *
    * @param keyboard A Scanner
    */
   public static void run(Scanner keyboard){
      String repeat;    // hold yes or no

      // Repeats the game as many times as the users want
      do {
         // Call showTwoDimArray method and pass the return value of the
         // getInput method as the parameter
         showTwoDimArray(getInput(keyboard));
         System.out.print("\nGo again? ");
         repeat = keyboard.nextLine();
      } while ("y".equalsIgnoreCase(repeat));
   }
}
