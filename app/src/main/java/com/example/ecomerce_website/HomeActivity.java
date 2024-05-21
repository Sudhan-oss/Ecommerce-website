package com.example.ecomerce_website;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ProductAdapter.OnItemClickListener {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private ArrayList<CartItem> cartItemList;
    private ImageView cartIcon;
    private Button cartButton;
    private SearchView searchView;
    private FloatingActionButton fabPurchaseHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        productRecyclerView = findViewById(R.id.productRecyclerView);
        cartIcon = findViewById(R.id.cartIcon);
        cartButton = findViewById(R.id.cartButton);
        searchView = findViewById(R.id.searchView);
        fabPurchaseHistory = findViewById(R.id.fabPurchaseHistory);

        // Initialize product list and cart item list
        productList = new ArrayList<>();
        cartItemList = new ArrayList<>();

        // Set up RecyclerView and adapter
        productAdapter = new ProductAdapter(this, productList, this);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.setAdapter(productAdapter);

        // Example: Populate productList with dummy data
        populateProductList();

        // Set click listener for cart icon
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCart();
            }
        });

        // Set click listener for cart button
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCart();
            }
        });

        // Set click listener for purchase history button
        fabPurchaseHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPurchaseHistory();
            }
        });

        // Set query listener for search view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search based on query
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Update search results as user types
                return false;
            }
        });
    }

    @Override
    public void onAddToCartClick(Product product) {
        boolean found = false;
        for (CartItem item : cartItemList) {
            if (item.getProductName().equals(product.getName())) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }
        if (!found) {
            cartItemList.add(new CartItem(product.getName(), product.getPrice(), 1));
        }
    }

    private void openCart() {
        Intent intent = new Intent(HomeActivity.this, CartActivity.class);
        intent.putExtra("cartItems", cartItemList);
        startActivity(intent);
    }

    private void openPurchaseHistory() {
        Intent intent = new Intent(HomeActivity.this, PurchaseHistoryActivity.class);
        startActivity(intent);
    }

    // Method to populate productList with dummy data (for demonstration)
    private void populateProductList() {
        // Add dummy products to productList
        productList.add(new Product("Product 1", 10.0));
        productList.add(new Product("Product 2", 15.0));
        productList.add(new Product("Product 3", 20.0));
        // Notify adapter of data change
        productAdapter.notifyDataSetChanged();
    }
}
