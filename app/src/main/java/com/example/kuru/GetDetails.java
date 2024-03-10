package com.example.kuru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GetDetails extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextStrength;
    private EditText editTextWeakness;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_details);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextStrength = findViewById(R.id.editTextStrength);
        editTextWeakness = findViewById(R.id.editTextWeakness);
        radioGroup = findViewById(R.id.radioGroup);
    }

    public void submitData(View view) {
        String name = editTextName.getText().toString();
        int age = Integer.parseInt(editTextAge.getText().toString());
        String strength = editTextStrength.getText().toString();
        String weakness = editTextWeakness.getText().toString();

        // Check which radio button is selected
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId == -1) {
            // No radio button is selected
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get the selected radio button
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String gender = selectedRadioButton.getText().toString();

        Intent intent;

        // Open respective activity based on selected gender
        if (gender.equals("Male")) {
            intent = new Intent(this, ViewDetails.class);
            finish();
        } else { // Assuming Female
            intent = new Intent(this, ViewDetailsGirl.class);
            finish();
        }

        // Pass data to the next activity
        intent.putExtra("NAME", name);
        intent.putExtra("AGE", age);
        intent.putExtra("STRENGTH", strength);
        intent.putExtra("WEAKNESS", weakness);

        startActivity(intent);
    }
}
