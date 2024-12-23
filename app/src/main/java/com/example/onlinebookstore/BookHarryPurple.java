package com.example.onlinebookstore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookHarryPurple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_harry_purple);

        // Find the back button in the layout
        TextView backButtonPurple = findViewById(R.id.backButtonPurple);

        // Get the origin information from the Intent
        Intent intent = getIntent();
        final String origin = intent.getStringExtra("origin");

        // Set the onClickListener for the back button
        backButtonPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("homepage".equals(origin)) {
                    // Navigate back to Homepage
                    Intent intent = new Intent(BookHarryPurple.this, Homepage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                } else if ("categories".equals(origin)) {
                    // Navigate back to Categories
                    Intent intent = new Intent(BookHarryPurple.this, Categories.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }
            }
        });


    }
}
