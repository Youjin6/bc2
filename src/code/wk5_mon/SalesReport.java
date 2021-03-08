package code.wk5_mon;

import java.io.*;    // For File class and FileNotFoundException
import java.util.*;  // For Scanner and InputMismatchException

/**
 * This program demonstrates how multiple exceptions can
 * be caught with one try statement.
 */

public class SalesReport {
    public static void main(String[] args) {
        String filename = "SalesData.txt"; // File name
        int months = 0;                    // Month counter
        double oneMonth;                   // One month's sales
        double totalSales = 0.0;           // Total sales
        double averageSales;               // Average sales

        try {
            // Open the file.
            File file = new File(filename);
            Scanner inputFile = new Scanner(file);

            // Process the contents of the file.
            while (inputFile.hasNext()) {
                // Get a month's sales amount.
                oneMonth = inputFile.nextDouble();

                // Accumulate the amount.
                totalSales += oneMonth;

                // Increment the month counter
                months++;
            }

            // Close the file.
            inputFile.close();

            // Calculate the average.
            averageSales = totalSales / months;

            // Display the results.
            System.out.printf("Number of months: %d\n" +
                            "Total Sales: $%,.2f\n" +
                            "Average Sales: $%,.2f\n",
                    months, totalSales, averageSales);
        } catch (FileNotFoundException e) {
            // Thrown by the Scanner constructor when
            // the file is not found.
            System.out.println("The file " + filename + " does not exist.");
        } catch (InputMismatchException e) {
            // Thrown by the Scanner class's nextDouble
            // method when a non-numeric value is found.
            System.out.println("Non-numeric data found in the file.");
        }

    }
}