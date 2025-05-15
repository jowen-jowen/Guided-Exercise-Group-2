package com.example.eigthguidedexercise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adpt;
    ArrayList<String> listOfNames;
    Spinner names;
    TextView res;
    Button btnAddName, btnDeleteName;
    EditText etAddName;

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

        listOfNames = new ArrayList<>(Arrays.asList("Name Here", "Papsi", "Pol", "Noy", "Che", "Kris", "Tin", "Renz", "Chan", "Ven", "Jher"));
        adpt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listOfNames);
        adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        names = findViewById(R.id.spnrNamesGE8);
        res = findViewById(R.id.tvResultsGE8);
        etAddName = findViewById(R.id.etAddNameGE8);
        btnAddName = findViewById(R.id.btnAddNameGE8);
        btnDeleteName = findViewById(R.id.btnDeleteNameGE8);

        names.setAdapter(adpt);
        showSelectedName();
        addNameToSpinner();
        deleteNameToSpinner();
    }

    public void showSelectedName() {
        names.setAdapter(adpt);
        names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    res.setText(String.format("Name: %s", listOfNames.get(position)));
                    Toast.makeText(getApplicationContext(), "Name: " + listOfNames.get(position), Toast.LENGTH_SHORT).show();
                } else {
                    res.setText("Name: ");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void addNameToSpinner(){
        names.setAdapter(adpt);
        btnAddName.setOnClickListener(v->{
            String addedName = etAddName.getText().toString().trim();
            if (!etAddName.getText().toString().isEmpty()) {
                Toast.makeText(this, "Added Name: " + addedName, Toast.LENGTH_SHORT).show();
                listOfNames.add(etAddName.getText().toString());
                adpt.notifyDataSetChanged();
                etAddName.setText("");
            }
        });
    }

    public void deleteNameToSpinner(){
        names.setAdapter(adpt);
        btnDeleteName.setOnClickListener(v ->{
            int selectedPos = names.getSelectedItemPosition();

            if(selectedPos >= 0 && names.getSelectedItemPosition() >0){
                String removedName = listOfNames.get(selectedPos);

                if(!removedName.equals("Name Here")){
                    listOfNames.remove(selectedPos);
                    adpt.notifyDataSetChanged();
                    Toast.makeText(this, removedName + " has been removed", Toast.LENGTH_SHORT).show();

                    int defaultIndex = listOfNames.indexOf("Name Here");
                    if (defaultIndex >= 0) {
                        names.setSelection(defaultIndex);
                    }
                }
                else{
                    Toast.makeText(this, "Cannot delete the default content", Toast.LENGTH_SHORT).show();
                }
            }

            else{
                Toast.makeText(this, "No name has been selected", Toast.LENGTH_SHORT).show();
            }
        });

    }
}