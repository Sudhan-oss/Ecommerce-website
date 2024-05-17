package com.example.ecomerce_website.;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class PurchaseHistoryActivity extends AppCompatActivity {

    private ListView listViewOrders;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);

        listViewOrders = findViewById(R.id.listViewOrders);
        orderList = new ArrayList<>();

        // Simulated order data (replace with actual data retrieval logic)
        orderList.add("Order #1 - Total: $50.00");
        orderList.add("Order #2 - Total: $30.00");
        orderList.add("Order #3 - Total: $70.00");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderList);
        listViewOrders.setAdapter(adapter);
    }
}
