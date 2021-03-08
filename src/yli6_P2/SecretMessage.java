package yli6_P2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This SecretMessage implements an application to decode a secret message
 *
 * @author Yucong Li
 * @version 1.0
 */
public class SecretMessage {
    /**
     * test and repeat the program and many time as the users want.
     *
     * @param args A string array containing the command line arguments.
     * @throws FileNotFoundException File not found
     */
    public static void main(String[] args) throws FileNotFoundException {

        String repeat;      // holds yes or no
        String filename;    // holds the filename
        MessageDecoder decoder;

        // Create a Scanner object
        Scanner keyboard = new Scanner(System.in);

        // Call printIntro method.
        printIntro();

        // Repeat the game as many times as users want
        do {

            // Gets the valid filename
            do {
                filename = getFilename(keyboard);

            } while (!isValidFile(filename));
            // Call getCharAndNum
            decoder = getCharAndNum(filename);

            System.out.println("Decoded: " + decoder);
            // Ask users if they want to repeat the game
            System.out.print("\nWould you like to try again? (no to exit): ");
            repeat = keyboard.nextLine();
        } while (!"no".equalsIgnoreCase(repeat));

        // Prints out goodbye message
        printBye();

        // Close the Scanner
        keyboard.close();

    }


    /**
     * Get each character and number from the plain text message.
     *
     * @param filename The filename
     * @throws FileNotFoundException File not found
     */
    public static MessageDecoder getCharAndNum(String filename) throws FileNotFoundException {
        char letter;    // holds the character
        int num;        // hold the number
        String sub;     // a sub array to hold each line of the raw message
        String numbers; // String type number
        final int NUM_POSITION = 2;

        // Creates a MessageDecoder instance
        MessageDecoder decoder = new MessageDecoder();

        // Gets the plain text
        String message = decoder.getPlainTextMessage(filename);

        // Splits the raw message by a new line
        ArrayList<String> text =
                new ArrayList<>(Arrays.asList(message.split("\n")));

        // Gets the number and character an add into the decoder linked list
        for (String s : text) {
            sub = s;
            // Gets the character
            letter = sub.charAt(0);
            // Gets the number
            numbers = sub.substring(NUM_POSITION);
            num = Integer.parseInt(numbers);
            //Adds into decoder
            decoder.insertInOrder(letter, num);
        }
        return decoder;
    }

    /**
     * Gets a filename
     *
     * @param keyboard A Scanner object
     * @return The filename
     */
    public static String getFilename(Scanner keyboard) {
        String filename;    // holds the filename

        // Prompts users for the filename
        System.out.print("Enter secret file name: ");
        filename = keyboard.nextLine();

        return filename;

    }



    /**
     * Checks to see that the user-specified file name refers to a valid
     * file on the disk and not a directory. Displays an error message to the
     * user if that is not the case.
     *
     * @param fName file name string to check
     * @return true if file exists on disk and is not a directory
     */
    private static boolean isValidFile(String fName) {

        File path = new File(fName);
        boolean isValid = path.exists() && !path.isDirectory();
        if (!isValid) {
            System.out.println("Please enter a correct file name or path!");
        }
        return isValid;
    }

    /**
     * Prints out the introduction message.
     */
    public static void printIntro() {
        System.out.println("This program reads an encoded message from a " +
                "file \n" +
                "supplied by the user and displays the contents of the \n" +
                "message before it was encoded.\n" +
                "The user can enter multiple files and the decoded \n" +
                "result words will become interleaved.\n");
    }

    /**
     * Prints out the goodbye message.
     */
    public static void printBye() {
        System.out.println("\nThank you for using the message decoder.");
    }

}
