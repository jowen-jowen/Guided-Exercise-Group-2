package com.example.appdet_ge2;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rbColors;

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
        rbColors = findViewById(R.id.rgColors);
        rbColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.rbRed == checkedId){
                    Toast.makeText(getApplicationContext(),"Color: RED", Toast.LENGTH_SHORT).show();
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
                if (R.id.rbBlue == checkedId){
                    Toast.makeText(getApplicationContext(),"Color: BLUE", Toast.LENGTH_SHORT).show();
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }
                if (R.id.rbYellow == checkedId){
                    Toast.makeText(getApplicationContext(),"Color: YELLOW", Toast.LENGTH_SHORT).show();
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }
                if (R.id.rbGreen == checkedId){
                    Toast.makeText(getApplicationContext(),"Color: GREEN", Toast.LENGTH_SHORT).show();
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }
        });
    }
}