package com.example.ecomerce_website;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CartAdapter extends ArrayAdapter<CartItem> {

    private final Context context;
    private final List<CartItem> cartItems;

    public CartAdapter(@NonNull Context context, @NonNull List<CartItem> objects) {
        super(context, R.layout.cart_item, objects);
        this.context = context;
        this.cartItems = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        }

        CartItem currentItem = cartItems.get(position);

        ImageView productImage = itemView.findViewById(R.id.product_image);
        TextView productName = itemView.findViewById(R.id.product_name);
        TextView productPrice = itemView.findViewById(R.id.product_price);
        TextView productQuantity = itemView.findViewById(R.id.product_quantity);

        productImage.setImageResource(currentItem.getImageResourceId());
        productName.setText(currentItem.getName());
        productPrice.setText("$" + currentItem.getPrice());
        productQuantity.setText("Quantity: " + currentItem.getQuantity());

        return itemView;
    }
}
