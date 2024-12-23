package com.example.onlinebookstore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinebookstore.R;

public class ShoppingCart extends AppCompatActivity {

    private CheckBox selectAllCheckBox;
    private CheckBox itemCheckBox1, itemCheckBox2;
    private Button checkoutButton, increaseQuantity1, decreaseQuantity1, increaseQuantity2, decreaseQuantity2;
    private ImageButton deleteButton1, deleteButton2, cartButton;
    private TextView quantityText1, quantityText2, subtotalAmount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        TextView backSC = findViewById(R.id.backSC);
        backSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(ShoppingCart.this, Homepage.class);
                startActivity(intent);
            }
        });

        Button checkoutButton = findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(ShoppingCart.this, Checkout.class);
                startActivity(intent);
            }
        });


    }
}