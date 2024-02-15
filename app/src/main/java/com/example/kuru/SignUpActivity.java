package com.example.kuru;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kuru.databinding.SignupBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {
    private SignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        ProgressBar progressDialog = new ProgressBar(this);

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.fullname.getText().toString();
                String number = binding.phonenumber.getText().toString();
                String email = binding.email.getText().toString().trim();
                String password = binding.password.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnSuccessListener(authResult -> {
                            Intent intent = new Intent(SignUpActivity.this, Login.class);
                            startActivity(intent);
                            progressDialog.setVisibility(View.INVISIBLE);
                            String uid = firebaseAuth.getUid();
                            if (uid != null) {
                                firestore.collection("User")
                                        .document(uid)
                                        .set(new Usermodel(name, email, number));
                            }
                        })
                        .addOnFailureListener(e -> {
                            try {
                                // Code that might throw an exception
                            } catch (Exception exception) {
                                String errorMessage = e.getMessage();
                                if (errorMessage != null) {
                                    Toast.makeText(SignUpActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SignUpActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
                                }
                            }
                            progressDialog.setVisibility(View.INVISIBLE);
                        });
            }
        });

        binding.gotologin.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), Login.class));
        });
    }
}

