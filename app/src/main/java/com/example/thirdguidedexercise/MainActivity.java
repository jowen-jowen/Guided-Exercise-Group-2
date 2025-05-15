package com.example.thirdguidedexercise;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button sum, ave , clear;
    Toast toast;
    View view ;
    TextView txtResults;
    ConstraintLayout main;
    double firstNum = 0, secondNum = 0, totalSum = 0, totalAve = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);

        clear = findViewById(R.id.btnClear);
        txtResults = findViewById(R.id.txtResults);
        num1 = findViewById(R.id.etNum1GE3);
        num2 = findViewById(R.id.etNum2GE3);
        sum = findViewById(R.id.btnSumGE3);
        ave = findViewById(R.id.btnAveGE3);

        computeTotal();
    }

    public void computeTotal(){
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this will check if our two EditText has a text value
                if(num1.getText().toString().isEmpty() ||
                        num2.getText().toString().isEmpty()){
                    displayErrorMessage();
                }else{
                    firstNum = Double.parseDouble(num1.getText().toString());
                    secondNum = Double.parseDouble(num2.getText().toString());
                    totalSum = firstNum + secondNum;
                    txtResults.setText("SUM " + totalSum);
                    main.setBackgroundResource(R.drawable.tralalero);
                }
            }
        });
        ave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // another way of checking if our two EditText has a text value
                if(num1.getText().length() <= 0 ||
                        num2.getText().length() <= 0 ){
                    displayErrorMessage();
                }else{
                    firstNum = Double.parseDouble(num1.getText().toString());
                    secondNum = Double.parseDouble(num2.getText().toString());
                    totalAve = (firstNum + secondNum) / 2;
                    txtResults.setText("AVE " + totalAve);
                    main.setBackgroundResource(R.drawable.crocodilo);

                }
            }

        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResults.setText("Results");
                main.setBackgroundColor(Color.WHITE);
                num1.setText("");
                num2.setText("");
            }
        });
    }
    public void displayErrorMessage(){
        toast = Toast.makeText(getApplicationContext(),
                "Please Enter a Number",Toast.LENGTH_SHORT);
        view = toast.getView();
        view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}