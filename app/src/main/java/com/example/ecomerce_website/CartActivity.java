package com.example.ecomerce_website;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private List<CartItem> cartItems;
    private CartAdapter cartAdapter;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItems = new ArrayList<>();
        // Add sample items to cart
        cartItems.add(new CartItem("Product 1", 10.0, 1, R.drawable.img_1));

        ListView cartListView = findViewById(R.id.cart_list_view);
        cartAdapter = new CartAdapter(this, cartItems);
        cartListView.setAdapter(cartAdapter);

        totalTextView = findViewById(R.id.total_price);
        updateTotal();
    }

    private void updateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        totalTextView.setText("$" + total);
    }

    public void onCheckoutClick(View view) {
        Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
        intent.putExtra("cartItems", (ArrayList<CartItem>) cartItems);
        startActivity(intent);
    }
}
