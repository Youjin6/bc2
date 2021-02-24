package yli6_P1;

public class TicTacToe {

    private enum Board {X, O, Empty}
    final int BOARD_SIZE = 3;


    private final Board[][] board = new Board[BOARD_SIZE][BOARD_SIZE];

    private int gameWon = 0;

    public TicTacToe() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = Board.Empty;
        }
    }

    public int gameStatus() {
        if (checkRow() || checkColumn() || checkDiagonal()) {
            return gameWon;
        }
        return 0;
    }

    public boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] &&
                    board[i][0] != Board.Empty) {
                if (board[i][0] == Board.X)
                    gameWon = 1;
                else
                    gameWon = 2;
                return true;
            }
        }

        return false;
    }

    public boolean checkColumn() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] &&
                    board[0][i] != Board.Empty) {
                if (board[1][i] == Board.X)
                    gameWon = 1;
                else
                    gameWon = 2;
                return true;
            }
        }

        return false;
    }

    public boolean checkDiagonal() {
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] &&
                board[0][0] != Board.Empty) {
            if (board[0][0] == Board.X)
                gameWon = 1;
            else
                gameWon = 2;
            return true;
        }
        if (board[2][0] == board[1][1] && board[2][0] == board[0][2] &&
                board[2][0] != Board.Empty) {
            if (board[2][0] == Board.X)
                gameWon = 1;
            else
                gameWon = 2;
            return true;
        }

        return false;

    }

    public void printGameStatus() {
        int status = gameStatus();

        if (status == 0)
//            System.out.println("No winner - it was a tie!");
            System.out.print("\n");
        else if (status == 1)
            System.out.println("Player 1 wins");
        else if (status == 2)
            System.out.println("Player 2 wins");
    }

    public boolean setMove(int player, int row, int column) {
        if (board[row][column] == Board.Empty) {
            if (player == 1)
                board[row][column] = Board.X;
            else
                board[row][column] = Board.O;
            return true;
        }


        return false;
    }


    public void printBoard() {
        System.out.println("\n");
        for (int i = 0; i < 3; i++) {
            System.out.print("\t" + i + "\t\t");

        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(i);
            for (int j = 0; j < 3; j++) {
                System.out.print("\t");
                System.out.printf("%s\t|\t", board[i][j] == Board.Empty ?
                        " " : (board[i][j] == Board.X ? "X" : "O"));

            }

            System.out.println();
            System.out.println(" ------------------------------");
        }
    }

}
