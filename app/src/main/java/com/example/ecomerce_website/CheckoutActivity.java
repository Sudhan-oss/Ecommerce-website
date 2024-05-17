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
    private CartListAdapter cartListAdapter;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Retrieve cart items passed from the CartActivity
        cartItems = (ArrayList<CartItem>) getIntent().getSerializableExtra("cartItems");

        ListView checkoutListView = findViewById(R.id.checkout_list_view);
        cartListAdapter = new CartListAdapter(this, cartItems);
        checkoutListView.setAdapter(cartListAdapter);

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
        // This can involve saving the order to a database, sending a confirmation email, etc.
        Toast.makeText(this, "Order confirmed!", Toast.LENGTH_SHORT).show();
    }
}
