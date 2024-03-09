package eCommerceApp;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User{
    private final List<Product> items;
    public Admin(String userName, String password, String email, String homeAddress, Product items) {
        super(userName, password, email, homeAddress);
        this.items = new ArrayList<>();
    }
    public void addProduct(Product product){
        for(Product item : items){
            if(item == product){
                items.add(product);
            }
        }
    }
    public void removeProduct(Product product){
        for(Product item : items){
            if(item == product){
                items.remove(product);
            }
            throw new GoodsNotFoundError("Goods not found in store");
        }
    }
}
