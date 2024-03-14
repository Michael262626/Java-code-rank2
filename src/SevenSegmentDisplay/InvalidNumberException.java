package SevenSegmentDisplay;

public class InvalidNumberException extends RuntimeException{
    public InvalidNumberException(String s){super("Not a valid number");}
}
