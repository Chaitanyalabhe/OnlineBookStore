package com.example.onlinebookstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BookLawakKampus40 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_lawak_kampus_40);

        // Find the back button in the layout
        TextView backButton40 = findViewById(R.id.backButton40);

        // Get the origin information from the Intent
        Intent intent = getIntent();
        final String origin = intent.getStringExtra("origin");

        // Set the onClickListener for the back button
        backButton40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("homepage".equals(origin)) {
                    // Navigate back to Homepage
                    Intent intent = new Intent(BookLawakKampus40.this, Homepage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                } else if ("categories".equals(origin)) {
                    // Navigate back to Categories
                    Intent intent = new Intent(BookLawakKampus40.this, Categories.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }
            }
        });
    }
}