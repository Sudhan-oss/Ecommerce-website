package com.example.ecomerce_website;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName, productPrice;
    private Spinner quantitySpinner;
    private Button addToCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);

        // Initialize views
        productImage = findViewById(R.id.image_product);
        productName = findViewById(R.id.text_product_name);
        productPrice = findViewById(R.id.text_product_price);
        quantitySpinner = findViewById(R.id.spinner_quantity);
        addToCartButton = findViewById(R.id.btn_add_to_cart);

        // Example data (replace with actual data)
        productImage.setImageResource(R.drawable.product_image_placeholder);
        productName.setText("Product Name");
        productPrice.setText("Price: $10.00");

        // Set up any additional functionality as needed
        // For example, adding a listener to the Add to Cart button
        addToCartButton.setOnClickListener(v -> addToCart());
    }

    private void addToCart() {
        // Add logic to add the selected product to the cart
    }
}

