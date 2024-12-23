package com.example.onlinebookstore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Homepage extends AppCompatActivity {
    private static final String API_KEY = "AIzaSyApZKvEdvc8qP9DkS2AqLBlhbzpGVV4bzc";

    private EditText searchInput;
    private ImageView searchIcon;
    private BooksApi booksApi;
    private RecyclerView recyclerViewBestSeller;
    private RecyclerView recyclerViewNewArrivals;
    private BookAdapter bestsellerAdapter;
    private BookAdapter newArrivalsAdapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        // Initialize API service
        booksApi = RetrofitInstance.getRetrofitInstance().create(BooksApi.class);

        // Initialize UI elements
        TextView userNameTextView = findViewById(R.id.tvGreeting); // Ensure this TextView exists in your layout
        ImageView cartIcon = findViewById(R.id.carth);
        ImageView profileIcon = findViewById(R.id.profileh);
        searchInput = findViewById(R.id.searchInput);
        searchIcon = findViewById(R.id.searchIcon);

        // Get the user's name from the intent
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");

        // Set the name in the greeting text
        userNameTextView.setText("Hi, " + (userName != null && !userName.isEmpty() ? userName : "User") + "!");

        // Initialize RecyclerViews for Bestseller and New Arrivals sections
        recyclerViewBestSeller = findViewById(R.id.recyclerViewBestSeller);
        recyclerViewNewArrivals = findViewById(R.id.recyclerViewNewArrivals);

        // Set layout managers
        recyclerViewBestSeller.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNewArrivals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Initialize adapters with empty lists
        bestsellerAdapter = new BookAdapter(new ArrayList<>());
        newArrivalsAdapter = new BookAdapter(new ArrayList<>());

        // Set adapters
        recyclerViewBestSeller.setAdapter(bestsellerAdapter);
        recyclerViewNewArrivals.setAdapter(newArrivalsAdapter);

        // Set up click listeners for navigation
        cartIcon.setOnClickListener(v -> startActivity(new Intent(Homepage.this, ShoppingCart.class)));
        profileIcon.setOnClickListener(v -> startActivity(new Intent(Homepage.this, Profile.class)));
        setupNavigationButtons();

        // Search functionality
        searchIcon.setOnClickListener(v -> {
            String query = searchInput.getText().toString().trim();
            if (!query.isEmpty()) {
                fetchBooks(query); // Fetch books based on the search query
            } else {
                Toast.makeText(Homepage.this, "Please enter a search term", Toast.LENGTH_SHORT).show();
            }
        });

        // Fetch and display "Bestseller" and "Newest" books
        fetchBestsellerBooks();
        fetchNewestBooks();
    }

    private void fetchBooks(String query) {
    }

    private void fetchBestsellerBooks() {
        Call<BookResponse> bestsellerCall = booksApi.getBestsellers("bestseller", 10, API_KEY);
        bestsellerCall.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                Log.d("API Response", "Bestsellers Response: " + response.body());
                if (response.isSuccessful() && response.body() != null) {
                    List<Volume> bestsellers = response.body().getItems();
                    if (bestsellers != null && !bestsellers.isEmpty()) {
                        bestsellerAdapter.setBooks(bestsellers);
                        bestsellerAdapter.notifyDataSetChanged();
                        Log.d("API Response", "Bestsellers Response List: " + bestsellers);
                    } else {
                        Log.d("API Response", "No bestsellers found");
                    }
                } else {
                    Log.d("API Response", "Response not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                String errorMessage = (t.getMessage() != null) ? t.getMessage() : "Unknown error occurred";
                Log.e("API Error", "Bestseller fetch failed: " + errorMessage);
                Toast.makeText(Homepage.this, "Failed to fetch bestseller data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchNewestBooks() {
        Call<BookResponse> newestCall = booksApi.getNewest("books", "newest", 10, API_KEY);
        newestCall.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                Log.d("API Response", "Newest Response: " + response.body());
                if (response.isSuccessful() && response.body() != null) {
                    List<Volume> newestBooks = response.body().getItems();
                    if (newestBooks != null && !newestBooks.isEmpty()) {
                        newArrivalsAdapter.setBooks(newestBooks);
                        newArrivalsAdapter.notifyDataSetChanged();
                    } else {
                        Log.d("API Response", "No newest books found");
                    }
                } else {
                    Log.d("API Response", "Response not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                Log.e("API Error", "Newest books fetch failed: " + t.getMessage());
                Toast.makeText(Homepage.this, "Failed to fetch newest books", Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Navigation button setup for various screens
    private void setupNavigationButtons() {
        ImageButton homeButtonH = findViewById(R.id.homeButtonH);
        homeButtonH.setOnClickListener(v -> startActivity(new Intent(Homepage.this, Homepage.class)));

        ImageButton bookmarkButtonH = findViewById(R.id.bookmarkButtonH);
        bookmarkButtonH.setOnClickListener(v -> startActivity(new Intent(Homepage.this, Bookmark.class)));

        ImageButton menuButtonH = findViewById(R.id.menuButtonH);
        menuButtonH.setOnClickListener(v -> startActivity(new Intent(Homepage.this, Categories.class)));

        ImageButton settingsButtonH = findViewById(R.id.settingsButtonH);
        settingsButtonH.setOnClickListener(v -> startActivity(new Intent(Homepage.this, Profile.class)));

    }

    // Navigate to a book's detail page
    private void navigateToBookDetail(Class<?> bookClass) {
        Intent intent = new Intent(Homepage.this, bookClass);
        startActivity(intent);
    }
}
