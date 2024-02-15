package com.example.kuru;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class GetDetails extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextStrength;
    private EditText editTextWeakness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_details);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextStrength = findViewById(R.id.editTextStrength);
        editTextWeakness = findViewById(R.id.editTextWeakness);
    }

    public void submitData(View view) {
        String name = editTextName.getText().toString();
        int age = Integer.parseInt(editTextAge.getText().toString());
        String strength = editTextStrength.getText().toString();
        String weakness = editTextWeakness.getText().toString();

        Intent intent = new Intent(this, ViewDetails.class);
        intent.putExtra("NAME", name);
        intent.putExtra("AGE", age);
        intent.putExtra("STRENGTH", strength);
        intent.putExtra("WEAKNESS", weakness);
        startActivity(intent);
    }
}
