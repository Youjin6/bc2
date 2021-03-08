package code.wk5_mon;

import java.io.*;  // For File class and FileNotFoundException
import java.util.Scanner;       // For the Scanner class

/**
 * This program demonstrates how a FileNotFoundException
 * exception can be handled.
 */

public class OpenFile {
    public static void main(String[] args) {
        File file;         // For file input
        Scanner inputFile; // For file input
        String fileName;   // To hold a file name

        // Create Scanner object
        Scanner keyboard = new Scanner(System.in);

        // Get a file name from the user.
        System.out.print("Enter the name of a file: ");
        fileName = keyboard.nextLine();

        // Attempt to open the file.
        try {
            file = new File(fileName);
            inputFile = new Scanner(file);
            System.out.println("The file was found.");
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found.");
        }

        System.out.println("Done.");

        // close Scanner
        keyboard.close();
    }
}