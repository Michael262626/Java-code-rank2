package eCommerceApp;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;
    private final List<Customer> customer;
    private List<Product> items;
    private final double totalAmount;
    public Order(int orderId, Customer customer, double totalAmount){
        this.orderId = orderId;
        this.customer = new ArrayList<>();
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void placeOrder(){

    }

}
