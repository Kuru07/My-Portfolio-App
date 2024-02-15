package com.example.kuru;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewDetails extends AppCompatActivity {
    private TextView textViewName;
    private TextView textViewAge;
    private TextView textViewStrength;
    private TextView textViewWeakness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_details);

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);
        textViewStrength = findViewById(R.id.textViewStrength);
        textViewWeakness = findViewById(R.id.textViewWeakness);

        // Retrieve values from intent extras
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        int age = intent.getIntExtra("AGE", 0); // Default value 0 if not found
        String strength = intent.getStringExtra("STRENGTH");
        String weakness = intent.getStringExtra("WEAKNESS");

        // Set values to TextViews
        textViewName.setText("Name: " + name);
        textViewAge.setText("Age: " + age);
        textViewStrength.setText("Strength: " + strength);
        textViewWeakness.setText("Weakness: " + weakness);
    }
}
