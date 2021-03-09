package _read;

import java.util.Scanner;

public class C02_tryCatchFinally {
    public static void main(String[] args) {
        int input;
        System.out.println("input 1 ,2 or 3");
        Scanner keyboard = new Scanner(System.in);
        try {
            input = keyboard.nextInt();

            switch (input) {
                case 1:
                    System.out.println("java");
                    break;
                case 2:
                    System.out.println("c++");
                    break;
                case 3:
                    System.out.println("c#");
                    break;
                default:
                    System.out.println("please enter 1,2 or 3");
            }
        } catch (Exception e) {
            System.out.println("please enter a integer");
        }
    }
}
