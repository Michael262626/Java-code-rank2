package eCommerceApp;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;
    private final Customer customer;
    private final List<Product> items;
    private double totalAmount;
    public Order(int orderId, Customer customer, double totalAmount, List<Product> items){
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void placeOrder(Customer customer, ShoppingCart shoppingCart){
        List<Product> items = shoppingCart.getItems();
        if(items.isEmpty()){
            throw new CartIsEmptyError("Cart cannot be empty");
        }
        Order order = new Order(orderId, customer, 0.0, items);
        double totalAmount = calculatedTotalAmount(items);
        order.setTotalAmount(totalAmount);
    }

    private void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private double calculatedTotalAmount(List<Product> items) {
        double totalAmount = 0.0;
        for(Product item : items){
            totalAmount += item.getPrice();
        }
        return totalAmount;
    }


}
