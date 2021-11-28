package ie.ul.foodapp.model;

import androidx.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

public class Customer {

    String Email;
    protected List<Offer> Orders;

    public Customer() {
        Email = null;
        Orders= new LinkedList<>();
    }

    public Customer(Customer c) {
        this.Email = c.Email;
        this.Orders = new LinkedList<>();
    }
    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Customer(this);
    }

    public String getEmail() { return Email; }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void addOrder(Offer order) { Orders.add(order); }

    public List<Offer> getOrders() { return Orders; }


}
