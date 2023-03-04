package com.english;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText emailRegister;
    private EditText passwordRegister;
    private EditText repeatedPassword;
    private Button signUpBtn;
    private Button loginOldAccount;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        mAuth = FirebaseAuth.getInstance();
        emailRegister = findViewById(R.id.email);
        passwordRegister = findViewById(R.id.password);
        repeatedPassword = findViewById(R.id.repassword);
        signUpBtn = findViewById(R.id.signupbtn);
        loginOldAccount = findViewById(R.id.goToSignIn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailRegister.getText().toString().isEmpty() || passwordRegister.getText().toString().isEmpty() || repeatedPassword.getText().toString().isEmpty()) {
                    Toast.makeText(SignUp.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    if(passwordRegister.getText().toString() == repeatedPassword.getText().toString()) {
                        mAuth.createUserWithEmailAndPassword(emailRegister.getText().toString(), passwordRegister.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(SignUp.this, MenuActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(SignUp.this, "ERROR123", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(SignUp.this, "Passwords must be the same!", Toast.LENGTH_SHORT).show();
                    }

                }
             }
        });

        loginOldAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
}
