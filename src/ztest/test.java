package ztest;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String input;
        Scanner kbd = new Scanner(System.in);

        System.out.print("inout: ");
        input = kbd.nextLine();
        Scanner scanner = new Scanner(input);
        int count = 0;
        String[] str = input.split(" ");
        while (count < str.length) {

            while (scanner.hasNextDouble()) {
                System.out.println(scanner.nextDouble());
                count++;
            }
            if (str[count].equals("+")){
                System.out.println("____");
                count++;
            }
        }
    }
}