import Model.Customer;
import Model.Order;
import Model.Partner;
import Model.Product;
import com.google.api.client.util.Data;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Rasmus on 17-03-2017.
 */
public class FirebaseImpl {
    private FirebaseDatabase db;
    private FirebaseAuth auth;
    static DatabaseReference ref;


    public FirebaseImpl() {
        initializeFirebase();
    }

    private void initializeFirebase() {
        // Fetch the service account key JSON file contents
        try {
            FileInputStream serviceAccount = new FileInputStream("serviceAccountKey.json");
            // Authenticate with FirebaseImpl
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                    .setDatabaseUrl("https://favordrop.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
            db = FirebaseDatabase.getInstance();
            db.setLogLevel(Logger.Level.DEBUG);
            auth = FirebaseAuth.getInstance();
            ref = FirebaseDatabase.getInstance().getReference();
        } catch (IOException e) {
            System.out.println("Service Account credentials not found: ");
            e.printStackTrace();
        }

    }

    public void addCustomer() {
        DatabaseReference customerRef = ref.child("customers");
        String ID = customerRef.push().getKey();
        customerRef.child(ID).setValue(new Customer("Joey moe", "Han bor sku på amar", "666666", "johnmogensne@hotmail.com"));
    }

    public void addOrder() {
        DatabaseReference orderRef = ref.child("new orders");
        String ID = orderRef.push().getKey();
        ArrayList<Product> list = new ArrayList<Product>();
        list.add(new Product("Vare157","Adresse2","Kommentar3"));
        list.add(new Product("stor fed dildo", "hjemmefra David", "Den behøver ikke blive vasket"));
        orderRef.child(ID).setValue(new Order(23452543,"Hejejejeje",list,89));
        sendNotification(ID);
    }

    public void addPartner() {
        DatabaseReference customerRef = ref.child("partners");
        String ID = customerRef.push().getKey();
        customerRef.child(ID).setValue(new Partner("Johnny",6666));
    }

    public void sendNotification(String id) {
        System.out.println("Så sendte man lige en android notifikation indeholdende" + id);
    }

    public void acceptOrder(String orderID, String partnerID) {
        DatabaseReference orderRef = ref.child("new orders").child(orderID).child("clientName");
        System.out.println("SÅ NÅEDE VI HER");
        System.out.println(orderRef.toString());
        System.out.println("SÅ NÅEDE VI HER 2");
    }
}
