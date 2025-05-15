package com.example.seventhguidedexercise;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView rate;
    Button click, close;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDialogBuilder = new AlertDialog.Builder(this);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar); // ⬅️ type cast added
        rate = (TextView) findViewById(R.id.tvResultGE7);      // ⬅️ type cast added
        click = (Button) findViewById(R.id.btnClickGE7);        // ⬅️ type cast added
        close = (Button) findViewById(R.id.btnCloseGE7);        // ⬅️ type cast added

        showRating();
        closeApplication();
    }

    public void showRating() {
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (rating >= 3) {
                rate.setTextColor(Color.GREEN);
            } else {
                rate.setTextColor(Color.RED);
            }
            rate.setText("Rate: " + rating);
        });

        click.setOnClickListener(view -> Toast.makeText(getApplicationContext(),
                "Rate: " + ratingBar.getRating(), Toast.LENGTH_SHORT).show());
    }

    public void closeApplication() {
        close.setOnClickListener(view -> {
            alertDialogBuilder.setTitle("Warning Message!")
                    .setMessage("Do you want to close the Application?")
                    .setPositiveButton("Yes", (dialogInterface, i) -> finish())
                    .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel())
                    .setCancelable(false)
                    .show();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        alertDialogBuilder.setTitle("Warning Message!")
                .setMessage("Do you want to close the Application?")
                .setPositiveButton("Yes", (dialogInterface, i) -> finish())
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel())
                .setCancelable(false)
                .show();
    }
}
