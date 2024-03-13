package eCommerceApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    public void testToOrderGoods(){
        CardType cardType = CardType.valueOf("5312345678901234");
        Category category = Category.ELECTRONICS;
        Customer myCustomer = new Customer("Michael Banks", "Michael2006#", "dikandumichael@gmail.com", "5, anthony", "5, anthony");
        Product product = new Product(1, "Laptop", 250_000, "Macbook pro", category);
        List<Product> items = new ArrayList<>();
        items.add(product);
        Order myorder = new Order(1, myCustomer, 250_000, items, cardType);
        //assertEquals(, );
    }

}