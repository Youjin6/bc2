package yli6_lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This Lab5 program reads the file lab5.dat and inserts the elements
 * into a linked list in non-descending order. Duplicates are then removed,
 * and the contents are displayed again.
 *
 * @author Youjin
 * @version 1.0
 */
public class Lab5 {
   /**
    * test each method
    *
    * @param args A string array containing the command line arguments.
    * @throws FileNotFoundException
    */
   public static void main(String[] args) throws FileNotFoundException {
      // test methods
      printIntro();
      readFromFile();
      printBye();
   }


   /**
    * Prints out the introduction message to the standard output
    */
   public static void printIntro() {
      System.out.println("This No Duplicates! program reads the " +
            "file lab5.dat and inserts the \nelements into a linked " +
            "list in non-descending order. The contents of \n" +
            "the linked list are then displayed to the user " +
            "in column form. \nDuplicates are then removed, " +
            "and the contents are displayed again.\n");
   }


   /**
    * Prints out the goodbye message.
    */
   public static void printBye() {
      System.out.println("Thanks for using the linked list program!");
   }


   /**
    * Read the integers from the file and creat a linked list to store them.
    * Then remove the duplicates and prints out the list again.
    *
    * @return A sequenced linked list.
    * @throws FileNotFoundException
    */
   public static LinkedList readFromFile() throws FileNotFoundException {
      int value;
      // hold the filename
      final String FILE_NAME = "lab5.dat";

      // Creates a File object
      File file = new File(FILE_NAME);

      // Creates a Scanner object
      Scanner inputFile = new Scanner(file);

      // Creates a linked list
      LinkedList myList = new LinkedList();

      // Prints out original content
      System.out.print("File contents: ");
      while (inputFile.hasNext()) {
         value = inputFile.nextInt();
         System.out.print(value + " ");
         myList.insertInOrder(value);
      }
      System.out.println();

      // Call printInsert
      printInsert();

      // Prints out the list
      System.out.println(myList);

      // Removing duplicates from the linked list
      printRemove();
      myList.removeDuplicates();

      // Prints out the list
      System.out.println(myList);

      // Close the Scanner
      inputFile.close();

      return myList;
   }


   /**
    * Prints out the inserting message
    */
   public static void printInsert() {
      System.out.println("Reading file, inserting nodes.. done.\n" +
              "Linked list contents after reading: ");
   }


   /**
    * Prints out the removing message
    */
   public static void printRemove() {
      System.out.println("Removing duplicates from the linked list.. done.\n"
              + "Linked list contents with no duplicates: ");
   }
}
