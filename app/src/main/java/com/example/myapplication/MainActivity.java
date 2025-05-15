package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // declaration of reference variables
    EditText name, age;
    TextView result;
    Button click;
    Button reset; // Declare the Reset button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 /*
 The reason we need to do type-casting is to call methods on the instance that are defined
 in that class. Sometimes, you may be fine with just the signature of the more general
 superclass.
 The type-casting doesn't do anything, really. findViewById is declared to return a View,
 since it can return all different kinds of Views. But in reality, it will often return an
 object of some other class, that is a subclass of View.
 */
        name = findViewById(R.id.etNameGE1);
        age = findViewById(R.id.etAgeGE1);
        result = findViewById(R.id.tvResultGE1); // Assuming this is the correct ID
        click = findViewById(R.id.btnClickGE1);
        reset = findViewById(R.id.btnResetGE1); // Initialize the Reset button

        // calling our user-defined method named showResult()
        showResult();
        setupResetButtonListener(); // Set up the listener for the Reset button
    }

    public void showResult() {
        // using .setOnClickListener for button click
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this will set the text value of the result
                result.setText("Name: " + name.getText().toString() +
                        "\nAge: " + age.getText().toString());
                // this will clear the text value of name and age
                name.setText("");
                age.setText("");
                // this will set the cursor to name
                name.requestFocus();
            }
        });
    }

    private void setupResetButtonListener() {
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the text in the EditText fields
                name.setText("");
                age.setText("");
                // Clear the text in the TextView
                result.setText("");
                // Set the focus back to the name field
                name.requestFocus();
            }
        });
    }

    // this user-defined method is another way of putting a function to our button click by simply
// calling this method on the onClick property of button click
// Note: don't forget the View parameter so that you can call it on the onClick property of the
// button click
    public void showResultAnotherWay(View view) {
        result.setText("Name: " + name.getText().toString() +
                "\nAge: " + age.getText().toString());
        name.setText("");
        age.setText("");
        name.requestFocus();
    }
}