package com.example.sixthguidedexercise;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox one, two, three, four;
    TextView result;
    Button click, clear;

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

        one = findViewById(R.id.chkOne);
        two = findViewById(R.id.chkTwo);
        three = findViewById(R.id.chkThree);
        four = findViewById(R.id.chkFour);
        result = findViewById(R.id.tvResultGE6);
        click = findViewById(R.id.btnClickGE6);
        clear = findViewById(R.id.btnClear);

        setupClickListener();
        setupClearListener();
    }

    private void setupClickListener() {
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (two.isChecked() && four.isChecked()) {
                    result.setVisibility(View.VISIBLE);
                    result.setBackgroundColor(Color.RED);
                    result.setTextColor(Color.BLACK);
                    result.setText("Number Combination \nColor is RED");
                } else if (one.isChecked() && three.isChecked()) {
                    result.setVisibility(View.VISIBLE);
                    result.setBackgroundColor(Color.BLUE);
                    result.setTextColor(Color.BLACK);
                    result.setText("Number Combination \nColor is BLUE");
                } else if ((one.isChecked() || three.isChecked()) ||
                        (two.isChecked() || four.isChecked())) {
                    result.setVisibility(View.VISIBLE);
                    result.setBackgroundColor(Color.GREEN);
                    result.setTextColor(Color.BLACK);
                    result.setText("Number Combination \nColor is GREEN");
                } else {
                    result.setVisibility(View.INVISIBLE);
                }
            }
        });
    }


    private void setupClearListener() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setChecked(false);
                two.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);

                result.setVisibility(View.INVISIBLE);
            }
        });
    }
}