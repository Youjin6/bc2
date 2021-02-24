package yli6_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) throws FileNotFoundException {
        printIntro();
        printMessage();
        System.out.println(readFromFile());
        printBye();

    }

    public static void printIntro() {
        System.out.println("This Linking It Up program reads the file lab4." +
                "dat and inserts the elements \ninto a linked list in" +
                " non-descending order.\nThe contents of the linked list " +
                "are then displayed to the user in column form.\n");
    }

    public static void printMessage(){
        System.out.println("Linked list contents:");
    }

    public static void printBye(){
        System.out.println("Thanks for using the linked list program!");
    }

    public static LinkedList readFromFile() throws FileNotFoundException {
        final String FILE_NAME = "lab4.dat";
        File file = new File(FILE_NAME);
        Scanner inputFile = new Scanner(file);
        LinkedList myList = new LinkedList();

        while (inputFile.hasNext()) {
            myList.insertInOrder(inputFile.nextInt());
        }
        inputFile.close();
        return myList;
    }
}
