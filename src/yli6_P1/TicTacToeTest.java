package yli6_P1;

import java.util.Scanner;

public class TicTacToeTest {

    public static void main(String[] args) {
        final int BOARD_SIZE = 3;
        TicTacToe game = new TicTacToe();
        Scanner keyboard = new Scanner(System.in);
        int count = 0;
        int inputRow;
        int inputCol;

        System.out.println("Welcome to TicTacToe (add more info about how to " +
                "play the game)");
        game.printBoard();

        do {
            while (true) {
                System.out.println("X, it is your turn.");
                System.out.print("Which row? ");
                inputRow = keyboard.nextInt();
                while (inputRow >= 3) {
                    System.out.print("Please enter a number between 0-2 ");
                    inputRow = keyboard.nextInt();
                }
                System.out.print("Which column? ");
                inputCol = keyboard.nextInt();
                while (inputCol >= 3) {
                    System.out.print("Please enter a number between 0-2 ");
                    inputCol = keyboard.nextInt();
                }


                if (game.setMove(1, inputRow, inputCol))
                    break;
            }
            count++;
            game.printGameStatus();
            game.printBoard();
            if (game.gameStatus() != 0)
                break;
            if (count >= 9) {
                System.out.println("Game Over");
                break;
            }
            while (true) {
                System.out.println("O, it is your turn.");
                System.out.print("Which row? ");
                inputRow = keyboard.nextInt();
                System.out.print("Which column? ");
                inputCol = keyboard.nextInt();
                if (game.setMove(2, inputRow, inputCol))
                    break;
            }
            count++;
            game.printGameStatus();
            game.printBoard();
            if (game.gameStatus() != 0)
                break;
            if (count >= 9) {
                System.out.println("No winner - it was a tie!");
                break;
            }
        } while (true);
        keyboard.close();
    }

}