package code.wk1.wk1_F;

import java.util.Scanner;

/**
   This program demonstrates the BankAccount class.
*/

public class AccountTest
{
   public static void main(String[] args)
   {
      String input;    // To hold user input

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);

      // Get the starting balance.
      System.out.print("What is your account's starting balance? $");
      input = keyboard.nextLine();

      // Create a BankAccount object.
      BankAccount account = new BankAccount(input);

      // Get the amount of pay.
      System.out.print("How much were you paid this month? $");
      input = keyboard.nextLine();

      // Deposit the user's pay into the account.
      account.deposit(input);

      // Display the new balance.
      System.out.printf("Your pay has been deposited.\n" +
                           "Your current balance is $%,.2f\n",
                           account.getBalance());

      // Withdraw some cash from the account.
      System.out.print("How much would you like to withdraw? $");
      input = keyboard.nextLine();
      account.withdraw(input);

      // Display the new balance
      System.out.printf("Now your balance is $%,.2f\n", account.getBalance());

      // close Scanner
      keyboard.close();
   }
}
