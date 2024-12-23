package com.example.onlinebookstore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Profile extends AppCompatActivity {

    private ImageView bookmarkIcon, profileImage;
    private ImageButton cartButton, homeButton, bookmarkButton, menuButton, settingsButton;
    private TextView bookmarkTitle, editNameButton;
    private EditText nameEditText, emailEditText, phoneEditText, addressEditText;

    boolean isEditing = false; // To toggle between edit and save mode

    private FirebaseAuth mAuth;
    private DatabaseReference userRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Initialize Firebase Auth and Database Reference
        mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getCurrentUser().getUid();
        userRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);

        // Initialize EditTexts for profile fields
        nameEditText = findViewById(R.id.editName);
        emailEditText = findViewById(R.id.editEmail);
        phoneEditText = findViewById(R.id.editPhone);
        addressEditText = findViewById(R.id.editAddress);

        // Load saved profile data from Firebase
        loadProfileData();

        // Initialize Edit Button
        editNameButton = findViewById(R.id.editNameButton);

        // Set the click listener for the edit button
        editNameButton.setOnClickListener(view -> {
            if (isEditing) {
                // Save the edited details and disable editing
                saveChanges();
            } else {
                // Enable editing
                enableEditing(true);
            }
            isEditing = !isEditing; // Toggle between edit and save mode
        });

        // Other existing buttons and logic for navigation
        ImageView logoutP = findViewById(R.id.logoutP);
        logoutP.setOnClickListener(v -> {
            Intent intent = new Intent(Profile.this, WelcomeActivity.class);
            startActivity(intent);
        });

        ImageButton homeButtonP = findViewById(R.id.homeButtonP);
        homeButtonP.setOnClickListener(v -> {
            Intent intent = new Intent(Profile.this, Homepage.class);
            startActivity(intent);
        });

        ImageButton bookmarkButtonP = findViewById(R.id.bookmarkButtonP);
        bookmarkButtonP.setOnClickListener(v -> {
            Intent intent = new Intent(Profile.this, Bookmark.class);
            startActivity(intent);
        });

        ImageButton menuButtonP = findViewById(R.id.menuButtonP);
        menuButtonP.setOnClickListener(v -> {
            Intent intent = new Intent(Profile.this, Categories.class);
            startActivity(intent);
        });

        ImageButton settingsButtonP = findViewById(R.id.settingsButtonP);
        settingsButtonP.setOnClickListener(v -> {
            Intent intent = new Intent(Profile.this, Profile.class);
            startActivity(intent);
        });
    }

    // Method to enable or disable editing for the EditTexts
    private void enableEditing(boolean enable) {
        nameEditText.setEnabled(enable);
        nameEditText.setFocusable(enable);
        nameEditText.setFocusableInTouchMode(enable);
        emailEditText.setEnabled(enable);
        emailEditText.setFocusable(enable);
        emailEditText.setFocusableInTouchMode(enable);
        phoneEditText.setEnabled(enable);
        phoneEditText.setFocusable(enable);
        phoneEditText.setFocusableInTouchMode(enable);
        addressEditText.setEnabled(enable);
        addressEditText.setFocusable(enable);
        addressEditText.setFocusableInTouchMode(enable);

        if (enable) {
            editNameButton.setText("Save"); // Change button text to 'Save'
        } else {
            editNameButton.setText("Edit"); // Change button text back to 'Edit'
        }
    }

    // Method to save changes made to the profile fields to Firebase
    private void saveChanges() {
        String newName = nameEditText.getText().toString();
        String newEmail = emailEditText.getText().toString();
        String newPhone = phoneEditText.getText().toString();
        String newAddress = addressEditText.getText().toString();

        // Create a map of the updated profile data
        Map<String, Object> profileData = new HashMap<>();
        profileData.put("name", newName);
        profileData.put("email", newEmail);
        profileData.put("phone", newPhone);
        profileData.put("address", newAddress);

        // Save the profile data to Firebase
        userRef.updateChildren(profileData).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(Profile.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Profile.this, "Failed to update profile", Toast.LENGTH_SHORT).show();
            }
            // Disable editing after saving
            enableEditing(false);
        });
    }

    // Method to load saved profile data from Firebase
    private void loadProfileData() {
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Retrieve the data from the snapshot
                    String savedName = snapshot.child("name").getValue(String.class);
                    String savedEmail = snapshot.child("email").getValue(String.class);
                    String savedPhone = snapshot.child("phone").getValue(String.class);
                    String savedAddress = snapshot.child("address").getValue(String.class);

                    // Set the retrieved data to EditTexts
                    nameEditText.setText(savedName != null ? savedName : "");
                    emailEditText.setText(savedEmail != null ? savedEmail : "");
                    phoneEditText.setText(savedPhone != null ? savedPhone : "");
                    addressEditText.setText(savedAddress != null ? savedAddress : "");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this, "Failed to load profile data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
