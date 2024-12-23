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

public class BookSappiens1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_sappiens1);

        TextView backButtonSappiens1 = findViewById(R.id.backButtonSappiens1);
        backButtonSappiens1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(BookSappiens1.this, Categories.class);
                startActivity(intent);
            }
        });

    }
}
