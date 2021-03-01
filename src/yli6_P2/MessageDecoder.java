package yli6_P2;



import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class MessageDecoder {

    public static String getPlainTextMessage(){

        String contents = "";
        final String FILENAME;
        LinkedList<String> list = new LinkedList();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter secret file name: ");
        FILENAME = keyboard.nextLine();

        Scanner inputFile = new Scanner(FILENAME);
        while (inputFile.hasNext()) {
            list.add(inputFile.next());
        }
        for (int i = 0; i < list.size(); i++) {
            contents += list.pop();

        }
        System.out.println(contents);
        return contents;

    }
    /**
     * Checks to see that the user-specified file name refers to a valid
     * file on the disk and not a directory. Displays an error message to the
     * user if that is not the case.
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

    public static void main(String[] args) {
        String text;
        text = getPlainTextMessage();

    }

}
