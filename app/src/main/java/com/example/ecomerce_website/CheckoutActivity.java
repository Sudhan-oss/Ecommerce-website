package com.example.ecomerce_website;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    private List<CartItem> cartItems;
    private CartAdapter cartAdapter;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Retrieve cart items passed from the CartActivity
        cartItems = (ArrayList<CartItem>) getIntent().getSerializableExtra("cartItems");

        ListView checkoutListView = findViewById(R.id.checkout_list_view);
        cartAdapter = new CartAdapter(this, cartItems);
        checkoutListView.setAdapter(cartAdapter);

        totalTextView = findViewById(R.id.checkout_total_price);
        updateTotal();
    }

    private void updateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        totalTextView.setText(String.format("$%.2f", total)); // Format total to display two decimal places
    }

    public void onConfirmOrderClick(View view) {
        // Handle order confirmation logic here
        Toast.makeText(this, "Order confirmed!", Toast.LENGTH_SHORT).show();
        // You may want to implement further logic here, such as submitting the order to a server
    }
}
