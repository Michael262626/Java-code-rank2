package LogisticService;

public class InvalidNumberError extends RuntimeException{
    public InvalidNumberError(String message){
        super(message);
    }

}
