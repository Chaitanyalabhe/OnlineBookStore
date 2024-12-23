package com.example.onlinebookstore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Bookmark extends AppCompatActivity {

    private ImageButton cartButton, homeButton, bookmarkButton, menuButton, settingsButton;
    private ImageView bookmarkIcon, searchIcon, bookThumbnail1, bookThumbnail2, bookmarkIcon1, bookmarkIcon2;
    private EditText searchInput;
    private TextView bookmarkTitle, bookTitle1, bookAuthor1, bookTitle2, bookAuthor2, bookPrice2;
    private CardView bookCard1, bookCard2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark); // Assuming your XML file is named activity_bookmark.xml

        ImageView cartbuttonB = findViewById(R.id.cartbuttonB);
        cartbuttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Bookmark.this, ShoppingCart.class);
                startActivity(intent);
            }
        });

        ImageButton homeButtonB = findViewById(R.id.homeButtonB);
        homeButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Bookmark.this, Homepage.class);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton bookmarkButtonB = findViewById(R.id.bookmarkButtonB);
        bookmarkButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Bookmark.this, Bookmark.class);
                startActivity(intent);
            }
        });


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton menuButtonB = findViewById(R.id.menuButtonB);
        menuButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Bookmark.this, Categories.class);
                startActivity(intent);
            }
        });


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton settingsButtonB = findViewById(R.id.settingsButtonB);
        settingsButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Bookmark.this, Profile.class);
                startActivity(intent);
            }
        });
    }
}
