package yli6_lab5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This Lab5 program reads the file lab4.dat and inserts the elements
 * into a linked list in non-descending order.
 *
 * @author Youjin
 * @version 1.0
 */
public class Lab5 {
    /**
     * Test each method
     *
     * @param args A string array containing the command line arguments.
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Call printIntro printMessage readFromFile and printBye method
        printIntro();
        printMessage();
        System.out.println(readFromFile());
        printBye();

        System.out.println();



    }

    /**
     * Prints out the introduction message to the standard output
     */
    public static void printIntro() {
        System.out.println("This Linking It Up program reads the file lab4." +
                "dat and inserts the elements \ninto a linked list in" +
                " non-descending order.\nThe contents of the linked list " +
                "are then displayed to the user in column form.\n");
    }

    /**
     * Prints out the linked list contents message.
     */
    public static void printMessage(){
        System.out.println("Linked list contents:");
    }

    /**
     * Prints out the goodbye message.
     */
    public static void printBye(){
        System.out.println("Thanks for using the linked list program!");
    }

    /**
     * Read the integers from the file and creat a linked list to store them.
     *
     * @return A sequenced linked list.
     * @throws FileNotFoundException
     */
    public static LinkedList readFromFile() throws FileNotFoundException {
        // hold the filename
        final String FILE_NAME = "lab5.dat";

        // Creates a File object
        File file = new File(FILE_NAME);

        // Creates a Scanner object
        Scanner inputFile = new Scanner(file);

        // Creates a linked list
        LinkedList myList = new LinkedList();

        // Adds the integers to the linked list
        while (inputFile.hasNext()) {
            myList.insertInOrder(inputFile.nextInt());

        }
        myList.removeDuplicates();
        System.out.println(myList);

        // Close the Scanner
        inputFile.close();

        return myList;
    }
}
