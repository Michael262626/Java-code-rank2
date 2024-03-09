package eCommerceApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItems(Product goods) {
        items.add(goods);
    }
    public List<Product> getItems() {
        return items;
    }

    public int getSize() {
        return items.size();
    }

    public void removeItems(Product product) {
        boolean found = false;
        Iterator<Product> iterator = items.iterator();
        while (iterator.hasNext()) {
            Product item = iterator.next();
            if (item.equals(product)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if(!found){
            throw new GoodsNotFoundError("Good not found in store");
        }
    }
}


