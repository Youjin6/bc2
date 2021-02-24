package yli6_P1;

import java.util.Scanner;

public class BadDesign {
    static int hold[][] = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        while (true) {
            display();
            System.out.println("\nPlayer 1 [X]:");
            System.out.print("Enter row [1-3]:");
            int r1 = s.nextInt();
            System.out.print("Enter column [1-3]:");
            int c1 = s.nextInt();
            hold[r1 - 1][c1 - 1] = 1;
            display();
            int c = check();
            if (c == 1) {
                System.out.println("Player 1 [X] wins!!");
                break;
            }
            if (c == 0) {
                System.out.println("Player 2 [O] wins!!");
                break;
            }
            if (c == -1) {
                System.out.println("Its a tie!!");
                break;
            }
            System.out.println("\nPlayer 2 [O]:");
            System.out.print("Enter row [1-3]:");
            int r2 = s.nextInt();
            System.out.print("Enter column [1-3]:");
            int c2 = s.nextInt();
            hold[r2 - 1][c2 - 1] = 0;
            c = check();
            if (c == 1) {
                System.out.println("Player 1 [X] wins!!");
                break;
            }
            if (c == 0) {
                System.out.println("Player 2 [O] wins!!");
                break;
            }
            if (c == -1) {
                System.out.println("Its a tie!!");
                break;
            }
        }
    }

    public static void display() {
        int i, j;
        System.out.println("Current playing status:");
        for (i = 0; i < 3; i++) {
            System.out.println("\n_____________");
            System.out.print("|");
            for (j = 0; j < 3; j++) {
                if (hold[i][j] == -1)
                    System.out.print("   |");
                if (hold[i][j] == 1)
                    System.out.print(" X |");
                if (hold[i][j] == 0)
                    System.out.print(" O |");
            }
        }
        System.out.println("\n_____________");
    }

    public static int check() {
        if (hold[0][0] == hold[0][1] && hold[0][0] == hold[0][2] && hold[0][0] != -1)
            return hold[0][0];
        else if (hold[1][0] == hold[1][1] && hold[1][0] == hold[1][2] && hold[1][0] != -1)
            return hold[1][0];
        else if (hold[2][0] == hold[2][1] && hold[2][0] == hold[2][2] && hold[2][0] != -1)
            return hold[2][0];

        else if (hold[0][0] == hold[1][0] && hold[0][0] == hold[2][0] && hold[0][0] != -1)
            return hold[0][0];
        else if (hold[0][1] == hold[1][1] && hold[0][1] == hold[2][1] && hold[0][1] != -1)
            return hold[0][1];
        else if (hold[0][2] == hold[1][2] && hold[0][2] == hold[2][2] && hold[0][2] != -1)
            return hold[0][2];


        else if (hold[0][0] == hold[1][1] && hold[0][0] == hold[2][2] && hold[0][0] != -1)
            return hold[0][0];
        else if (hold[0][2] == hold[1][1] && hold[0][2] == hold[2][0] && hold[0][2] != -1)
            return hold[0][2];
        else if (hold[0][0] != -1 && hold[0][1] != -1 && hold[0][2] != -1
                && hold[1][0] != -1 && hold[1][1] != -1 && hold[1][2] != -1
                && hold[2][0] != -1 && hold[2][1] != -1 && hold[2][2] != -1)
            return -1;
        else return 2;
    }
}

