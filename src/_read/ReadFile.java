package _read;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This ReadFile program implements an application that read data from a file
 * named "data.csv", then generate the outputs file and prints out the
 * results to the standard output.
 *
 * @author youjin
 * @version 1.0
 */
public class ReadFile {
    /**
     * Main function
     *
     * @param args A array to command line
     * @throws FileNotFoundException data.csv
     */
    public static void main(String[] args) throws FileNotFoundException {

        int test;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("----注意: 请把原始文件名改为 data.csv----\n");
        System.out.println("(0-48)        Enter 1");
        System.out.println("(0-24, 24-48) Enter 2");

        System.out.print("Enter: ");

        test = keyboard.nextInt();
        if (test == 1) {
            genFile_LF();
        }
        if (test == 2) {
            genFile_MF_LM();
        }
    }


    /**
     * Reads a single file
     *
     * @param doubles Raw data
     */
    public static void calculate(ArrayList<Double> doubles) {
        double num1;
        double num2;
        ArrayList<Double> first = new ArrayList<>();
        for (int i = 0; i < doubles.size(); i = i + 24) {
            first.add(doubles.get(i));
        }
        num1 = (first.get(0) - first.get(1)) / 4;
        num2 = (first.get(1) - first.get(2)) / 4;
        System.out.println(first.size());
        System.out.printf("%.1f\n", num1);
        System.out.printf("%.1f\n", num2);
    }

    /**
     * Generates an array to hold the Mid-First data
     *
     * @param doubles The data read from the raw file
     * @return A Mid-First ArrayList
     */
    public static ArrayList<Double> getMF_arr(ArrayList<Double> doubles) {

        // mid - first
        ArrayList<Double> M_F = new ArrayList<>();

        ArrayList<Double> listFirst = new ArrayList<>();
        ArrayList<Double> listMid = new ArrayList<>();

        for (int i = 0; i < doubles.size(); i = i + 49) {
            listFirst.add(doubles.get(i));
        }
        for (int i = 24; i < doubles.size(); i = i + 49) {
            listMid.add(doubles.get(i));
        }


        // 所有的 mid - first 数组
        for (int i = 0; i < listFirst.size(); i++) {
            M_F.add((listMid.get(i) - listFirst.get(i)) / 4);
        }


        return M_F;
    }


    /**
     * Generates an array to hold the Last-Mid data
     *
     * @param doubles The data read from the raw file
     * @return A Last-Mid ArrayList
     */
    public static ArrayList<Double> getLM_Arr(ArrayList<Double> doubles) {


        // last - mid
        ArrayList<Double> L_M = new ArrayList<>();

        ArrayList<Double> listMid = new ArrayList<>();
        ArrayList<Double> listLast = new ArrayList<>();

        for (int i = 24; i < doubles.size(); i = i + 49) {
            listMid.add(doubles.get(i));
        }
        for (int i = 48; i < doubles.size(); i = i + 49) {
            listLast.add(doubles.get(i));
        }


        // 所有的 last - mid 数组
        for (int i = 0; i < listLast.size(); i++) {
            L_M.add((listLast.get(i) - listMid.get(i)) / 4);
        }

        return L_M;
    }

    /**
     * Generates an array to hold the Last-First data
     *
     * @param doubles The data read from the raw file
     * @return A Last-First ArrayList
     */
    public static ArrayList<Double> getLF_arr(ArrayList<Double> doubles) {
        ArrayList<Double> L_F = new ArrayList<>();
        ArrayList<Double> listFirst = new ArrayList<>();
        ArrayList<Double> listLast = new ArrayList<>();

        for (int i = 0; i < doubles.size(); i = i + 49) {
            listFirst.add(doubles.get(i));
        }

        for (int i = 48; i < doubles.size(); i = i + 49) {
            listLast.add(doubles.get(i));
        }

        for (int i = 0; i < listFirst.size(); i++) {
            L_F.add((listLast.get(i) - listFirst.get(i)) / 8);
        }

        return L_F;

    }

    /**
     * Splits the raw data by ","
     *
     * @return An array holds the waste
     * @throws FileNotFoundException data.csv
     */
    public static ArrayList<Double> strSplitW() throws FileNotFoundException {
        double numW;
        String contents;
        String[] values;
        ArrayList<Double> arrayListW = new ArrayList<>();

        String fileName = "data1.csv";
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()) {
            contents = inputFile.nextLine();
            values = contents.split(",");
            numW = Double.parseDouble(values[0]);
            arrayListW.add(numW);
        }

        inputFile.close();

        return arrayListW;
    }

    /**
     * Splits the raw data by ","
     *
     * @return An array holds the replacement
     * @throws FileNotFoundException data.csv
     */
    public static ArrayList<Double> strSplitR() throws FileNotFoundException {
        double numR;
        String contents;
        String[] values;

        ArrayList<Double> arrayListR = new ArrayList<>();

        String fileName = "data.csv";
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()) {
            contents = inputFile.nextLine();
            values = contents.split(",");
            numR = Double.parseDouble(values[1]);
            arrayListR.add(numR);
        }

        inputFile.close();
        return arrayListR;
    }

    /**
     * Splits the raw data by ","
     *
     * @return An array holds the Total
     * @throws FileNotFoundException data.csv
     */
    public static ArrayList<Double> strSplitT() throws FileNotFoundException {
        double numT;
        String contents;
        String[] values;
        ArrayList<Double> arrayListT = new ArrayList<>();
        String fileName = "data.csv";
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()) {
            contents = inputFile.nextLine();
            values = contents.split(",");
            numT = Double.parseDouble(values[2]);
            arrayListT.add(numT);
        }


        inputFile.close();

        return arrayListT;
    }


    /**
     * Generates a file to keep the Last_First data
     *
     * @throws FileNotFoundException data.csv
     */
    public static void genFile_LF() throws FileNotFoundException {
        String filename;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nOutput file name(with extension): ");
        filename = keyboard.nextLine();
        PrintWriter outputFile = new PrintWriter(filename);

        System.out.println("\n--------WASTE----------------------------------");
        outputFile.println("WASTE");
        ArrayList<Double> waste1 = getLF_arr(strSplitW());
        for (Double aDouble : waste1) {
            outputFile.printf("%.1f\n", aDouble);
            System.out.printf("%.1f\n", aDouble);
        }

        outputFile.println();
        System.out.println("\n--------REPLACEMENT----------------------------");
        outputFile.println("REPLACEMENT");
        ArrayList<Double> replacement = getLF_arr(strSplitR());

        for (Double aDouble : replacement) {
            outputFile.printf("%.1f\n", aDouble);
            System.out.printf("%.1f\n", aDouble);
        }

        outputFile.println();
        System.out.println("\n--------TOTAL----------------------------------");
        outputFile.println("TOTAL");
        ArrayList<Double> total = getLF_arr(strSplitT());

        for (Double aDouble : total) {
            outputFile.printf("%.1f\n", aDouble);
            System.out.printf("%.1f\n", aDouble);
        }

        outputFile.close();
        keyboard.close();
    }


    /**
     * Generates a file to keep the Mid_First and Last_Mid data
     *
     * @throws FileNotFoundException data.csv
     */
    public static void genFile_MF_LM() throws FileNotFoundException {
        String filename;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nOutput file name(with extension): ");
        filename = keyboard.nextLine();
        PrintWriter outputFile = new PrintWriter(filename);

        System.out.println("\n--------WASTE----------------------------------");
        outputFile.println("WASTE");
        ArrayList<Double> waste1 = getMF_arr(strSplitW());
        ArrayList<Double> waste2 = getLM_Arr(strSplitW());

        for (int i = 0; i < waste1.size(); i++) {
            outputFile.printf("%.1f\n", waste1.get(i));
            System.out.printf("%.1f\n", waste1.get(i));
            outputFile.printf("%.1f\n", waste2.get(i));
            System.out.printf("%.1f\n", waste2.get(i));
        }

        outputFile.println();
        System.out.println("\n--------REPLACEMENT----------------------------");
        outputFile.println("REPLACEMENT");
        ArrayList<Double> replacement1 = getMF_arr(strSplitR());
        ArrayList<Double> replacement2 = getLM_Arr(strSplitR());

        for (int i = 0; i < replacement1.size(); i++) {
            outputFile.printf("%.1f\n", replacement1.get(i));
            System.out.printf("%.1f\n", replacement1.get(i));
            outputFile.printf("%.1f\n", replacement2.get(i));
            System.out.printf("%.1f\n", replacement2.get(i));
        }

        outputFile.println();
        System.out.println("\n--------TOTAL----------------------------------");
        outputFile.println("TOTAL");
        ArrayList<Double> total1 = getMF_arr(strSplitT());
        ArrayList<Double> total2 = getLM_Arr(strSplitT());

        for (int i = 0; i < total1.size(); i++) {
            outputFile.printf("%.1f\n", total1.get(i));
            System.out.printf("%.1f\n", total1.get(i));
            outputFile.printf("%.1f\n", total2.get(i));
            System.out.printf("%.1f\n", total2.get(i));
        }

        outputFile.close();
        keyboard.close();
    }
}
