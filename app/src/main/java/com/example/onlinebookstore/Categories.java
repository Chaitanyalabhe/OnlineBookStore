package com.example.onlinebookstore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class Categories extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageButton menuSideBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        // Initialize DrawerLayout and ImageButton for the navigation drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        menuSideBar = findViewById(R.id.menuSideBar);

        // Set click listener to open the drawer when the menu button is clicked
        menuSideBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer if it's already open
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);  // Open the drawer
                }
            }
        });

        // Cart Button
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView cartSC = findViewById(R.id.cartSC);
        cartSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, ShoppingCart.class);
                startActivity(intent);
            }
        });

        // Home Button
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton homeButtonC = findViewById(R.id.homeButtonC);
        homeButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Homepage.class);
                startActivity(intent);
            }
        });

        // Bookmark Button
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton bookmarkButtonC = findViewById(R.id.bookmarkButtonC);
        bookmarkButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Bookmark.class);
                startActivity(intent);
            }
        });

        // Menu Button
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton menuButtonC = findViewById(R.id.menuButtonC);
        menuButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Categories.class);
                startActivity(intent);
            }
        });

        // Settings Button
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton settingsButtonC = findViewById(R.id.settingsButtonC);
        settingsButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Profile.class);
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast") ImageView CategoriesHarryRed = findViewById(R.id.CategoriesHarryRed);
        CategoriesHarryRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Categories.this, BookDescription.class);
                intent.putExtra("origin", "categories");
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast") ImageView CategoriesHarryGreen = findViewById(R.id.CategoriesHarryGreen);
        CategoriesHarryGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Categories.this, BookHarryGreen.class);
                intent.putExtra("origin", "categories");
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast") ImageView CategoriesHarryPurple = findViewById(R.id.CategoriesHarryPurple);
        CategoriesHarryPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Categories.this, BookHarryPurple.class);
                intent.putExtra("origin", "categories");
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast") ImageView CategoriesLawakKampus39 = findViewById(R.id.CategoriesLawakKampus39);
        CategoriesLawakKampus39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Categories.this, BookLawakKampus39.class);
                intent.putExtra("origin", "categories");
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast")
        ImageView CategoriesLawakKampus40 = findViewById(R.id.CategoriesLawakKampus40);
        CategoriesLawakKampus40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to BookLawakKampus40 and passes the origin as "categories"
                Intent intent = new Intent(Categories.this, BookLawakKampus40.class);
                intent.putExtra("origin", "categories"); // Pass "categories" as the origin
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast") ImageView CategoriesLawakKampus392 = findViewById(R.id.CategoriesLawakKampus392);
        CategoriesLawakKampus392.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Categories.this, BookLawakKampus39.class);
                intent.putExtra("origin", "categories");
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast") ImageView CategoriesWBBA = findViewById(R.id.CategoriesWBBA);
        CategoriesWBBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Categories.this, BookAir.class);
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast") ImageView CategoriesSappiens1 = findViewById(R.id.CategoriesSappiens1);
        CategoriesSappiens1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Categories.this, BookSappiens1.class);
                startActivity(intent);
            }
        });

        @SuppressLint("WrongViewCast") ImageView CategoriesSappiens2 = findViewById(R.id.CategoriesSappiens2);
        CategoriesSappiens2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Log In screen
                Intent intent = new Intent(Categories.this, BookSappiens2.class);
                startActivity(intent);
            }
        });


    }
}
