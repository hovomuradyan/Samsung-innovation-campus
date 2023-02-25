package com.english;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button signUpBtn = findViewById(R.id.signupbtn);
        signUpBtn.setOnClickListener(view -> {
            EditText email = findViewById(R.id.email);
            String email1 = email.getText().toString();
            if (email1.contains("@")) {
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
            }
        });
    }
}
