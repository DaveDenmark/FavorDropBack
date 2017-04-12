package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Rasmus on 20-03-2017.
 */
public class Order {
    public int client_id;
    public ArrayList<Product> products;
    public int estimatedPrice;
    public String clientName;
    public Date orderTime;

    public Order(int client_id, String clientName, ArrayList<Product> products, int estimatedPrice) {
        this.client_id = client_id;
        this.clientName = clientName;
        this.products = products;
        this.estimatedPrice = estimatedPrice;
        this.orderTime = new Date();
    }

    public Order() {
    }
}
