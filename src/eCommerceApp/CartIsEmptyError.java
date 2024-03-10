package eCommerceApp;

public class CartIsEmptyError extends RuntimeException{
    public CartIsEmptyError(String message){
        super(message);
    }
}
