package Model;

import java.util.ArrayList;

/**
 * Created by Rasmus on 20-03-2017.
 */
public class Customer {
    public String name;
    public String address;
    public double rating;
    public int numOfRatings;
    public String phone;
    public String email;
    public ArrayList<Order> orders;

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.rating = 0;
        this.numOfRatings = 0;
        this.phone = phone;
        this.orders = null;

    }

    public Customer() {
    }
}
