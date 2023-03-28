package com.english;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailRegister;
    private EditText passwordRegister;
    private EditText repeatedPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        mAuth = FirebaseAuth.getInstance();
        emailRegister = findViewById(R.id.email);
        passwordRegister = findViewById(R.id.password);
        repeatedPassword = findViewById(R.id.repassword);
        Button signUpBtn = findViewById(R.id.signupbtn);
        Button loginOldAccount = findViewById(R.id.goToSignIn);

        signUpBtn.setOnClickListener(v -> {
            if (emailRegister.getText().toString().isEmpty() || passwordRegister.getText().toString().isEmpty() || repeatedPassword.getText().toString().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                if(passwordRegister.getText().toString().equals(repeatedPassword.getText().toString())) {
                    mAuth.createUserWithEmailAndPassword(emailRegister.getText().toString(), passwordRegister.getText().toString()).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            finish();
                            Intent intent = new Intent(SignUpActivity.this, MenuActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUpActivity.this, "Password must be 8+ symbols | Contact moderator", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "Passwords must be the same!", Toast.LENGTH_SHORT).show();
                }

            }
         });

        loginOldAccount.setOnClickListener(v -> {
            finish();
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
        });
    }
}
