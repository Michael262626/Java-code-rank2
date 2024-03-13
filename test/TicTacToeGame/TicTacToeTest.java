package TicTacToeGame;

import org.junit.jupiter.api.Test;

import static TicTacToeGame.Cell.*;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    @Test
    public void testThatBoardExist() {
        TicTacToe.initializeBoard(TicTacToe.board);
        assertEquals(EMPTY, TicTacToe.board[0][0] = EMPTY);
    }

    @Test
    public void testThatTheCellsCanChangeToO() {
        TicTacToe.initializeBoard(TicTacToe.board);
        assertEquals(O, TicTacToe.board[0][0] = O);
    }

    @Test
    public void testThatCellsCanChangeToX() {
        TicTacToe.initializeBoard(TicTacToe.board);
        assertEquals(X, TicTacToe.board[0][0] = X);
    }

    @Test
    public void testThatCantPlayInACellTwice() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[0][0] = X;
        TicTacToe.board[0][0] = O;
        assertThrows(InvalidMoveError.class, () -> TicTacToe.isValidMove(TicTacToe.board, 0, 0));
    }

    @Test
    public void testForMovesOutOfTheCells() {
        TicTacToe.initializeBoard(TicTacToe.board);
        assertThrows(InvalidMoveError.class, () -> TicTacToe.isValidMove(TicTacToe.board, 0, 9));


    @Test
    void checkWinner() {
        TicTacToe.initializeBoard(TicTacToe.board);
        assertFalse(TicTacToe.checkWin(TicTacToe.board, X));
        assertFalse(TicTacToe.checkWin(TicTacToe.board, O));
        TicTacToe.board[0][0] = Cell.X;
        TicTacToe.board[0][1] = Cell.X;
        TicTacToe.board[0][2] = Cell.X;
        assertTrue(TicTacToe.checkWin(TicTacToe.board, X));
        assertFalse(TicTacToe.checkWin(TicTacToe.board, O));
    }

    @Test
    void checkWinner2() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[1][0] = Cell.O;
        TicTacToe.board[1][1] = Cell.O;
        TicTacToe.board[1][2] = Cell.O;
        assertTrue(TicTacToe.checkWin(TicTacToe.board, O));
        assertFalse(TicTacToe.checkWin(TicTacToe.board, X));
    }

    @Test
    void checkWinner3() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[0][0] = Cell.X;
        TicTacToe.board[1][1] = Cell.X;
        TicTacToe.board[2][2] = Cell.X;
        assertTrue(TicTacToe.checkWin(TicTacToe.board, X));
        assertFalse(TicTacToe.checkWin(TicTacToe.board, O));
    }

    @Test
    void checkWinner4() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[2][0] = Cell.O;
        TicTacToe.board[1][1] = Cell.O;
        TicTacToe.board[0][2] = Cell.O;
        assertFalse(TicTacToe.checkWin(TicTacToe.board, X));
        assertTrue(TicTacToe.checkWin(TicTacToe.board, O));
    }

    @Test
    void checkWinner5() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[0][2] = Cell.X;
        TicTacToe.board[1][2] = Cell.X;
        TicTacToe.board[2][2] = Cell.X;
        assertTrue(TicTacToe.checkWin(TicTacToe.board, X));
        assertFalse(TicTacToe.checkWin(TicTacToe.board, O));
    }

    @Test
    void checkWinner6() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[0][1] = Cell.O;
        TicTacToe.board[1][1] = Cell.O;
        TicTacToe.board[2][1] = Cell.O;
        assertFalse(TicTacToe.checkWin(TicTacToe.board, X));
        assertTrue(TicTacToe.checkWin(TicTacToe.board, O));
    }

    @Test
    void checkWinner7() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[2][0] = Cell.X;
        TicTacToe.board[2][1] = Cell.X;
        TicTacToe.board[2][2] = Cell.X;
        assertTrue(TicTacToe.checkWin(TicTacToe.board, X));
        assertFalse(TicTacToe.checkWin(TicTacToe.board, O));
    }

    @Test
    void checkWinner8() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[2][0] = Cell.O;
        TicTacToe.board[1][1] = Cell.O;
        TicTacToe.board[0][2] = Cell.O;
        assertTrue(TicTacToe.checkWin(TicTacToe.board, O));
        assertFalse(TicTacToe.checkWin(TicTacToe.board, X));
    }

    @Test
    void checkDraw() {
        TicTacToe.initializeBoard(TicTacToe.board);
        TicTacToe.board[0][0] = Cell.X;
        TicTacToe.board[0][1] = Cell.O;
        TicTacToe.board[1][0] = Cell.X;
        TicTacToe.board[2][0] = Cell.O;
        TicTacToe.board[1][1] = Cell.X;
        TicTacToe.board[2][2] = Cell.O;
        TicTacToe.board[2][1] = Cell.X;
        TicTacToe.board[0][2] = Cell.O;
        TicTacToe.board[1][2] = Cell.X;
        //assertFalse(TicTacToe.checkWin(TicTacToe.board, X));
        assertFalse(TicTacToe.checkWin(TicTacToe.board, O));
    }

}