package com.example.ecomerce_website;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private ImageView cartIcon;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        productRecyclerView = findViewById(R.id.productRecyclerView);
        cartIcon = findViewById(R.id.cartIcon);
        SearchView searchView = findViewById(R.id.searchView);

        // Initialize product list and adapter
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, productList);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.setAdapter(productAdapter);

        // Example: Populate productList with dummy data
        populateProductList();

        // Set click listener for cart icon
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open cart activity or fragment
                // Example: startActivity(new Intent(HomeActivity.this, CartActivity.class));
            }
        });

        // Set query listener for search view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search based on query
                // Example: performSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Update search results as user types
                // Example: updateSearchResults(newText);
                return false;
            }
        });
    }

    // Method to populate productList with dummy data (for demonstration)
    private void populateProductList() {
        // Add dummy products to productList
        productList.add(new Product("Product 1", "$10.00"));
        productList.add(new Product("Product 2", "$15.00"));
        productList.add(new Product("Product 3", "$20.00"));
        // Add more products as needed
        // Notify adapter of data change
        productAdapter.notifyDataSetChanged();
    }
}
