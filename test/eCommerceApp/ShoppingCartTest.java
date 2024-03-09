package eCommerceApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart myCart;
    @BeforeEach
    void setUp() {
        myCart = new ShoppingCart();
    }
    @Test
    public void testICanAddToMyCart(){
        Product product1 = new Product(1, "Glass", 500.0, "Sunshades for fashion", Category.CLOTHING);
        myCart.addItems(product1);
        assertEquals(1, myCart.getSize());
    }
    @Test
    public void testToRemoveItemsFromCart(){
        Product product1 = new Product(1, "Glass", 500.0, "Sunshades for fashion", Category.CLOTHING);
        Product product2 = new Product(2, "Shorts", 1500.0, "Blue shorts form germany", Category.CLOTHING);
        myCart.addItems(product1);
        myCart.addItems(product2);
        myCart.removeItems(product1);
        assertEquals(1, myCart.getSize());
    }
    @Test
    public void testToAddMoreThanOneItemsToTheCart(){
        Product product1 = new Product(1, "Glass", 500.0, "Sunshades for fashion", Category.CLOTHING);
        Product product2 = new Product(2, "Shorts", 1500.0, "Blue shorts form germany", Category.CLOTHING);
        myCart.addItems(product1);
        myCart.addItems(product2);
        assertEquals(2, myCart.getSize());
    }
    @Test
    public void testToRemoveMoreThanOneItemsBeenAdded(){
        Product product1 = new Product(1, "Glass", 500.0, "Sunshades for fashion", Category.CLOTHING);
        Product product2 = new Product(2, "Shorts", 1500.0, "Blue shorts form germany",Category.CLOTHING);
        Product product3 = new Product(3, "Shirts", 3000.0, "Quality baggy top", Category.CLOTHING);
        Product product4 = new Product(4, "Trousers", 3000.0, "Quality cargo trousers", Category.CLOTHING);
        myCart.addItems(product1);
        myCart.addItems(product2);
        myCart.addItems(product3);
        myCart.addItems(product4);
        myCart.removeItems(product1);
        myCart.removeItems(product3);
        assertEquals(2, myCart.getSize());
    }

}