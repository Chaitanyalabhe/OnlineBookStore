package com.example.onlinebookstore;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class LoginActivity extends AppCompatActivity {

    private EditText emailPhoneUsername;
    private EditText password;
    private Button logInButton;
    private FirebaseAuth mAuth;  // Firebase Auth instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Connects to the login XML layout

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        emailPhoneUsername = findViewById(R.id.emailPhoneUsername);
        password = findViewById(R.id.password);
        logInButton = findViewById(R.id.logInButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic for handling login
                String userInput = emailPhoneUsername.getText().toString();
                String userPassword = password.getText().toString();

                if (userInput.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in both email and password fields.", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userInput).matches()) {
                    Toast.makeText(LoginActivity.this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                } else {
                    // Authenticate the user
                    mAuth.signInWithEmailAndPassword(userInput, userPassword)
                            .addOnCompleteListener(LoginActivity.this, task -> {
                                if (task.isSuccessful()) {
                                    // Login successful, retrieve user name from Firebase
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user != null) {
                                        String userId = user.getUid();
                                        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);

                                        usersRef.child("name").addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                String name = dataSnapshot.getValue(String.class); // Get the user's name

                                                // Navigate to Homepage with the user's name
                                                Intent homeIntent = new Intent(LoginActivity.this, Homepage.class);
                                                homeIntent.putExtra("USER_NAME", name); // Pass user name to homepage
                                                startActivity(homeIntent);
                                                finish(); // Close LoginActivity
                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {
                                                Toast.makeText(LoginActivity.this, "Error retrieving user data.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                } else {
                                    // Handle login failure
                                    String errorMessage = "Login failed: ";
                                    try {
                                        throw task.getException();
                                    } catch (FirebaseAuthInvalidUserException e) {
                                        errorMessage += "No account found with this email.";
                                    } catch (FirebaseAuthInvalidCredentialsException e) {
                                        errorMessage += "Incorrect password. Please try again.";
                                    } catch (Exception e) {
                                        errorMessage += "Authentication error. Please try again later.";
                                    }
                                    Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                                }
                            });
                }
            }
        });

        TextView signInLink = findViewById(R.id.signInLink);
        signInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigates to the Sign In screen
                Intent intent = new Intent(LoginActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}