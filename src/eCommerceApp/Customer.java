package eCommerceApp;

public class Customer extends User{
    private final String deliveryAddress;

    public Customer(String userName, String password, String email, String homeAddress, String deliverAddress) {
        super(userName, password, email, homeAddress);
        this.deliveryAddress = deliverAddress;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }


}
