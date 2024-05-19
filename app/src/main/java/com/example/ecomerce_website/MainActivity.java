package com.example.ecomerce_website;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button login_Button, register_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        usernameEditText = findViewById(R.id.UserName_input);
        passwordEditText = findViewById(R.id.Password_input);
        login_Button = findViewById(R.id.login_button);
        register_Btn = findViewById(R.id.Register_Btn);

        // Set onClickListener for the loginButton
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values from EditText fields
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if username and password are not empty
                if (!username.isEmpty() && !password.isEmpty()) {
                    // Show a Toast message for logging in
                    Toast.makeText(MainActivity.this, "Logging in...", Toast.LENGTH_SHORT).show();

                    // Navigate to HomePageActivity after the toast message
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    // Display error message if username or password is empty
                    Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set onClickListener for the registerButton
        register_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to RegisterActivity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
