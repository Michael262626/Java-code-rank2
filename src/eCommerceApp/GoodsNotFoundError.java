package eCommerceApp;

public class GoodsNotFoundError extends RuntimeException{
    public GoodsNotFoundError(String message){
        super(message);
    }
}
