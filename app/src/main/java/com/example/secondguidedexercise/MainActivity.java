package com.example.secondguidedexercise;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button click;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.etNameGE2);
        click = findViewById(R.id.btnClickGE2);
        showResult();
    }

    @SuppressLint("SetTextI18n")
    private void showResult() {
        click.setOnClickListener(view -> {
            String userInput = name.getText().toString();

            View layout = getLayoutInflater().inflate(R.layout.custom_toast, findViewById(R.id.main), false);
            TextView toastText = layout.findViewById(R.id.toast_text);

            toastText.setText("Hello " + userInput + "!\nWelcome to Android Development!");

            Toast customToast = new Toast(getApplicationContext());
            customToast.setDuration(Toast.LENGTH_SHORT);
            customToast.setView(layout);
            customToast.setGravity(Gravity.CENTER, 0, 0);
            customToast.show();
        });
    }
}
