package com.example.onlinebookstore;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {

    // Declare all the UI elements
    private TextView backButton, checkoutTitle, deliveryAddressText;
    private ImageView itemImage, visaLogo, masterCardLogo;
    private TextView itemTitle, itemAuthor, itemPrice;
    private TextView orderTotalAmount, itemSubtotalAmount, shippingSubtotalAmount, totalPaymentAmount;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout); // Ensure that this matches your XML filename

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView backButtonC = findViewById(R.id.backButtonC);
        backButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Checkout.this, ShoppingCart.class);
                startActivity(intent);
            }
        });
    }
}
