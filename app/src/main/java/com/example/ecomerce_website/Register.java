package com.example.ecomerce_website;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, confirmPasswordEditText, emailEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        usernameEditText = findViewById(R.id.UserName_input);
        passwordEditText = findViewById(R.id.Password_input);
        confirmPasswordEditText = findViewById(R.id.confirm_Password_input);
        emailEditText = findViewById(R.id.Email_Address_input);
        registerButton = findViewById(R.id.Register_btn);

        // Set onClickListener for the registerButton
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform registration
                performRegistration();
            }
        });
    }

    private void performRegistration() {
        // Get the input values from EditText fields
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();
        String email = emailEditText.getText().toString();

        // Validate input (you may add more validation)
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty()) {
            // Display error message if any field is empty
            Toast.makeText(RegisterActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if password and confirm password match
        if (!password.equals(confirmPassword)) {
            // Display error message if passwords don't match
            Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Here you would typically perform registration logic
        // For demonstration, just show a Toast message
        Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();

        // Redirect to login page after registration
        finish(); // Close the current activity (register page)
    }
}
