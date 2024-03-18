package BankApplication;

import java.util.ArrayList;
import java.util.List;

public class Customer{
private String id;
private String name;
private String email;
private List<Customer> customers = new ArrayList<>();

public Customer(String id, String name, String email){
    this.customers = new ArrayList<>();
    this.name = name;
    this.id = id;
    this.email = email;
}


public void add(Customer newCustomer) {
    this.customers = new ArrayList<>();
}
    }