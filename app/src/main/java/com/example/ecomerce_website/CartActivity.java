package com.example.ecomerce_website;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCart;
    private CartAdapter cartAdapter;
    private ArrayList<CartItem> cartItemList;
    private TextView textViewTotal;
    private Button btnPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize views
        recyclerViewCart = findViewById(R.id.recyclerViewCart);
        textViewTotal = findViewById(R.id.textViewTotal);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);

        // Initialize cart item list (replace with actual data retrieval logic)
        cartItemList = new ArrayList<>();
        // Example data:
        cartItemList.add(new CartItem("Product 1", 10.0, 2));
        cartItemList.add(new CartItem("Product 2", 20.0, 1));
        cartItemList.add(new CartItem("Product 3", 30.0, 3));

        // Set up RecyclerView and adapter
        cartAdapter = new CartAdapter(this, cartItemList);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCart.setAdapter(cartAdapter);

        // Calculate and display total price
        double totalPrice = calculateTotalPrice(cartItemList);
        textViewTotal.setText("Total: $" + totalPrice);

        // Handle place order button click
        btnPlaceOrder.setOnClickListener(v -> placeOrder());
    }

    private double calculateTotalPrice(ArrayList<CartItem> cartItemList) {
        double totalPrice = 0;
        for (CartItem item : cartItemList) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    private void placeOrder() {
        // Start the CheckoutActivity and pass the cart items
        Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
        intent.putExtra("cartItems", cartItemList);
        startActivity(intent);
    }
}
