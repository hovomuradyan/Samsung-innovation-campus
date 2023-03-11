package com.english;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignIn extends AppCompatActivity {

    private EditText emailLogin;
    private EditText passwordLogin;
    private Button loginBtn;
    private ImageView googleBtn;
    private Button createNewAccount;
    private FirebaseAuth mAuth;

    private GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        mAuth = FirebaseAuth.getInstance();
        emailLogin = findViewById(R.id.email);
        passwordLogin = findViewById(R.id.password);
        loginBtn = findViewById(R.id.signupbtn);
        createNewAccount = findViewById(R.id.goToSignUp);
        googleBtn = (ImageView) findViewById(R.id.googleBtn);

        loginBtn.setOnClickListener(v -> {
            if (emailLogin.getText().toString().isEmpty() || passwordLogin.getText().toString().isEmpty()) {
                Toast.makeText(SignIn.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                mAuth.signInWithEmailAndPassword(emailLogin.getText().toString(), passwordLogin.getText().toString()).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        finish();
                        Intent intent = new Intent(SignIn.this, MenuActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignIn.this, "Error: Incorrect login or password", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        createNewAccount.setOnClickListener(v -> {
            finish();
            Intent intent = new Intent(SignIn.this, SignUp.class);
            startActivity(intent);
        });

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        googleBtn.setOnClickListener(v -> {
            Log.d("google:", "Begin Google SignIn");
            Intent intent = googleSignInClient.getSignInIntent();
            startActivityForResult(intent, 100);
        });

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Log.d("google", "onActivityResult: Google Signin intent result");
            Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = accountTask.getResult(ApiException.class);
                firebaseAuthWithGoogleAccount(account);
            }
            catch (Exception e) {
                Log.d("google:", "onActivityResult: "+e.getMessage());
            }
    }
}

    private void firebaseAuthWithGoogleAccount(GoogleSignInAccount account) {
        Log.d("google:", "firebaseAuthWithGoogleAccount: begin firebase");
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnSuccessListener(authResult -> {
                    Log.d("google", "onSuccess: Logged In");
                    Intent intent = new Intent(SignIn.this, MenuActivity.class);
                    startActivity(intent);
                })
                .addOnFailureListener(e -> Log.d("google", "onFailure: Login failed"+e.getMessage()));
    }
}
