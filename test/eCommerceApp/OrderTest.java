package eCommerceApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class OrderTest {

    @Test
    public void testToOrderGoods(){
        CardType cardType = CardType.MASTER_CARD;
        Category category = Category.ELECTRONICS;
        Customer myCustomer = new Customer("Michael Banks", "Michael2006#", "dikandumichael@gmail.com", "5, anthony", "5, anthony");
        Product product = new Product(1, "Laptop", 250_000, "Macbook pro", category);
        List<Product> items = new ArrayList<>();
        items.add(product);
        Order myorder = new Order(1, myCustomer, 250_000, items, cardType);
        assertEquals(1, myorder.getListOfItems());
    }
    @Test
    public void testToIdentifyCardType(){
        CardType cardType = CardType.MASTER_CARD;
        Customer myCustomer = new Customer("Michael Banks", "Michael2006#", "dikandumichael@gmail.com", "5, anthony", "5, anthony");
        List<Product> items = new ArrayList<>();
        Order myorder = new Order(1, myCustomer, 250_000, items, cardType);
        assertEquals(CardType.VISA_CARD, myorder.getCardType("413245637812435678"));
    }
    @Test
    public void testToIdentifyCardType2(){
        CardType cardType = CardType.MASTER_CARD;
        Customer myCustomer = new Customer("Michael Banks", "Michael2006#", "dikandumichael@gmail.com", "5, anthony", "5, anthony");
        List<Product> items = new ArrayList<>();
        Order myorder = new Order(1, myCustomer, 250_000, items, cardType);
        assertEquals(CardType.MASTER_CARD, myorder.getCardType("5312345678901234"));
    }
    @Test
    public void testToOrderMoreThanOneGoods(){
        CardType cardType = CardType.MASTER_CARD;
        Category category = Category.ELECTRONICS;
        Customer myCustomer = new Customer("Michael Banks", "Michael2006#", "dikandumichael@gmail.com", "5, anthony", "5, anthony");
        Product product1 = new Product(1, "Laptop", 250_000, "Macbook pro", category);
        Product product2 = new Product(1, "Iphone", 150_000, "Apple phone 11", category);
        List<Product> items = new ArrayList<>();
        items.add(product2);
        items.add(product1);
        Order myorder = new Order(1, myCustomer, 250_000, items, cardType);
        assertEquals(2, myorder.getListOfItems());
    }
    @Test
    public void testToOrderGoodsAndCancelTheOrderedGoods(){
        CardType cardType = CardType.MASTER_CARD;
        Category category = Category.ELECTRONICS;
        Customer myCustomer = new Customer("Michael Banks", "Michael2006#", "dikandumichael@gmail.com", "5, anthony", "5, anthony");
        Product product1 = new Product(1, "Laptop", 250_000, "Macbook pro", category);
        Product product2 = new Product(2, "Iphone", 150_000, "Apple phone 11", category);
        List<Product> items = new ArrayList<>();
        items.add(product2);
        items.add(product1);
        items.remove(product1);
        Order myorder = new Order(1, myCustomer, 250_000, items, cardType);
        assertEquals(1, myorder.getListOfItems());
    }
    @Test
    public void testToConfirmIdOfProduct(){
        CardType cardType = CardType.MASTER_CARD;
        Category category = Category.ELECTRONICS;
        Customer myCustomer = new Customer("Michael Banks", "Michael2006#", "dikandumichael@gmail.com", "5, anthony", "5, anthony");
        Product product1 = new Product(1, "Laptop", 250_000, "Macbook pro", category);
        List<Product> items = new ArrayList<>();
        items.add(product1);
        Order myorder = new Order(1, myCustomer, 250_000, items, cardType);
        assertEquals(1, myorder.getOrderId());
    }
}