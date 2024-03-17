package eCommerceApp;
import java.util.List;

public class Order {
    private final int orderId;
    private final Customer customer;
    private final List<Product> items;
    private CardType creditCard;
    private double totalAmount;

    public Order(int orderId, Customer customer, double totalAmount, List<Product> items, CardType creditCard) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.totalAmount = totalAmount;
        this.creditCard = creditCard;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void placeOrder(Customer customer, ShoppingCart shoppingCart) {
        List<Product> items = shoppingCart.getItems();
        if (items.isEmpty()) {
            throw new CartIsEmptyError("Cart cannot be empty");
        }
        creditCard = CardType.valueOf("5312345678901234");
        Order order = new Order(orderId, customer, 0.0, items, creditCard);
        if (isCreditCardValid(String.valueOf(creditCard))) {

            double totalAmount = calculatedTotalAmount(items);
            order.setTotalAmount(totalAmount);
        }else{
            throw new InvalidCardExceptionError("Card is invalid");
        }
    }

    private void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private double calculatedTotalAmount(List<Product> items) {
        double totalAmount = 0.0;
        for (Product item : items) {
            totalAmount += item.getPrice();
        }
        return totalAmount;
    }

    public CardType getCreditCard() {
        return creditCard;
    }

    public CardType getCardType(String cardNumber) {
        if (cardNumber.startsWith("4")) {
            return CardType.VISA_CARD;
        } else if (cardNumber.startsWith("5")) {
            return CardType.MASTER_CARD;
        } else if (cardNumber.startsWith("37") || cardNumber.startsWith("34")) {
            return CardType.AMERICAN_EXPRESS;
        } else if (cardNumber.startsWith("6")) {
            return CardType.DISCOVER;
        } else {
            return CardType.UNKNOWN;
        }

    }
    private boolean isCreditCardValid(String cardNumber){
        return cardNumber.charAt(0) == '4' || cardNumber.charAt(0) == '5' || cardNumber.charAt(0) == '3' + '7' || cardNumber.charAt(0) == '3' + '4' || cardNumber.charAt(0) == '6' && cardNumber.length() == 16 || cardNumber.length() == 15;
    }

    public int getListOfItems() {
        return items.size();
    }
}
