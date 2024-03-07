package TicTacToeGame;

public class InvalidMoveError extends RuntimeException{
    public InvalidMoveError(String message){
        super(message);
    }
}
