package TicTacToeGame;
import java.util.Scanner;
public class TicTacToe {
    static Scanner scanner = new Scanner(System.in);
    static Player player1 = new Player("Player1:", Cell.X);
    static Player player2 = new Player("Player2:", Cell.O);
    static Cell[][] board = new Cell[3][3];

    static Player currentPlayer = player1;
    static void playGame() {
        boolean gameOver = false;
        while (!gameOver) {
            displayBoard();
            System.out.println(currentPlayer.getName() + "enter your move 1 - 9");
            int move = scanner.nextInt();
            int row = (move - 1) / 3;
            int coloumn = (move - 1) % 3;
            try {
                if (isValidMove(board, row, coloumn)) {
                    board[row][coloumn] = currentPlayer.getCell();
                    if (checkWin(board, currentPlayer.getCell())) {
                        displayBoard();
                        System.out.println(currentPlayer.getName() + "Wins");
                        gameOver = true;

                    } else if (isBoardFull(board)) {
                        displayBoard();
                        System.out.println("It's a draw");
                        gameOver = true;
                    } else {
                        currentPlayer = (currentPlayer == player1) ? player2 : player1;
                    }
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void displayBoard() {
        System.out.println("-------------------");
        for (int count = 0; count < 3; count++) {
            System.out.print("| ");
            for (int counter = 0; counter < 3; counter++) {
                System.out.print(board[count][counter].getValue() + " | ");
            }
            System.out.println("\n-------------------");
        }
    }
    public static void initializeBoard(Cell[][] board) {
        for (int count = 0; count < 3; count++) {
            for (int counter = 0; counter < 3; counter++) {
                System.out.print(board[count][counter] = Cell.EMPTY);
            }
        }
    }
    public static boolean isValidMove(Cell[][] board, int row, int column) {
        if (row >= 0 && row <= 3 && column >= 0 && column <= 3 && board[row][column] == Cell.EMPTY) return true;
        throw new InvalidMoveError("Error: cell is occupied");
    }
    static boolean checkWin(Cell[][] board, Cell cell) {
        for (int count = 0; count < 3; count++) {
            if (board[count][0] == cell && board[count][1] == cell && board[count][2] == cell ||
                    board[0][count] == cell && board[1][count] == cell && board[2][count] == cell)
                return true;
        }
        return board[2][2] == cell && board[1][1] == cell && board[0][0] == cell;
    }
    public static boolean isBoardFull(Cell[][] board) {
        for (int count = 0; count < 3; count++) {
            for (int counter = 0; counter < 3; counter++) {
                if (board[count][counter] == Cell.EMPTY) return false;
            }
        }
        return true;
    }
}
