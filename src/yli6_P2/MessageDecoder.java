package yli6_P2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MessageDecoder {

    public static String getPlainTextMessage() throws FileNotFoundException {

        String contents = "";
        String filename;
        Scanner keyboard = new Scanner(System.in);

        // Gets the valid filename
        do {
            System.out.print("Enter secret file name: ");
            filename = keyboard.nextLine();
        } while (!isValidFile(filename));

        // Reads the file
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()) {
            contents = inputFile.nextLine();
            String[] a = contents.split(" ");
            System.out.print(a[0]+ " ");
            System.out.println(a[1]);


        }

        // Close the Scanner
        inputFile.close();
        keyboard.close();

        return contents;
    }


    /**
     * Checks to see that the user-specified file name refers to a valid
     * file on the disk and not a directory. Displays an error message to the
     * user if that is not the case.
     *
     * @param fname file name string to check
     * @return true if file exists on disk and is not a directory
     */
    private static boolean isValidFile(String fname) {
        File path = new File(fname);
        boolean isValid = path.exists() && !path.isDirectory();
        if (!isValid) {
            System.out.println("Please enter a correct file name or path!");
        }
        return isValid;
    }

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<String> list = new LinkedList<>();
        String text;
        text = getPlainTextMessage();


//        for (char c : text.toCharArray()) {
//            System.out.print(c);
//        }
//
//        System.out.println(text);
        System.out.println("\nlength of the test is: " + text.length());



    }

}
