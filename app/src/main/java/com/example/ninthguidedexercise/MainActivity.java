package com.example.ninthguidedexercise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView studentPhoto;
    TextView etName, grade;
    ListView name;
    ArrayAdapter adapter;
    String[] listOfNames =
            {"Jhoe When, Jowen", "Carpio, Jerome", "Jardenil, Daniel", "Carrasca, Jhon Michael", "Tralalelo, Tralala", "Crocodilo, Bombardino"};
    double[] listOfSemGrades = {1.00, 1.50, 2.00, 1.25, 3.00, 5.00};
    int[] studentImages = {
            R.drawable.jowen,
            R.drawable.jer,
            R.drawable.jardenil,
            R.drawable.carrasca,
            R.drawable.tralalero,
            R.drawable.crocodilo,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etname);
        grade = findViewById(R.id.editTextNumberDecimal);
        studentPhoto = findViewById(R.id.imageView);
        name = findViewById(R.id.lvNameGE9);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfNames) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextSize(30);
                return view;
            }
        };
        name.setAdapter(adapter);

        showSemGrade();
    }

    public void showSemGrade() {
        name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                etName.setText(" Name: " + listOfNames[i]);
                grade.setText(String.valueOf(" Sem Grade: " + listOfSemGrades[i]));
                studentPhoto.setImageResource(studentImages[i]);
            }
        });
    }

}