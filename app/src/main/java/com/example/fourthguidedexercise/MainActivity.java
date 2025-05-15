package com.example.fourthguidedexercise;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    TextView result;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  findViewById() can return null, so it's good practice to check.
        username = findViewById(R.id.etUsernameGE4);
        password = findViewById(R.id.etPasswordGE4);
        result = findViewById(R.id.tvResultGE4);
        login = findViewById(R.id.btnLoginGE4);

        // It's generally better to set up listeners in onCreate.
        setupLoginButtonListener(); // Renamed for clarity
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
        username.setTextColor(Color.WHITE);
        password.setTextColor(Color.WHITE);
    }

    //  Extracting the listener to its own method improves readability.
    private void setupLoginButtonListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Moved the logic directly into the listener.
                handleLogin(); //Call handleLogin()
            }
        });
    }

    private void handleLogin() {
        if (username == null || password == null || result == null) {
            Log.e("MainActivity", "One or more views are null.  Check your layout.");
            return; // Important: Exit if views are not initialized.  Prevents NullPointerExceptions
        }

        String enteredUsername = username.getText().toString().trim(); // added trim()
        String enteredPassword = password.getText().toString().trim(); // added trim()

        if ("papsi".equals(enteredUsername) && "android".equals(enteredPassword)) {
            result.setText("WELCOME PAPSI !"); // Changed to uppercase as in the picture.
            result.setTextColor(Color.GREEN);
            result.setTextSize(20);
        } else {
            result.setText("USERNAME AND PASSWORD DOES NOT EXIST!"); //  Changed to uppercase as in the picture.
            result.setTextColor(Color.WHITE);
            result.setTextSize(20);
        }
        clearEntry();
    }

    private void clearEntry() {
        if (result != null && username != null && password != null) { //Added null checks
            result.setVisibility(View.VISIBLE);
            username.setText("");
            password.setText("");
            username.requestFocus();
        }
    }
}