package com.example.onlinebookstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookSappiens2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_sappiens2);

        TextView backButtonSappiens2 = findViewById(R.id.backButtonSappiens2);
        backButtonSappiens2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(BookSappiens2.this, Categories.class);
                startActivity(intent);
            }
        });

    }
}
