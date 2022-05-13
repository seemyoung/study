package com.example.cchat.activities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.cchat.R;
import com.example.cchat.databinding.ActivitySignInBinding;

import static android.app.ProgressDialog.show;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private EditText inputEmail;
    private EditText inputPassword;
    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        signInButton = findViewById(R.id.buttonSignin);
        signInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String pwd = inputPassword.getText().toString().trim();
                login(email, pwd);
            }
        });
    }

    private void login(String email,String pwd) {
        if (email == null || email.length() <= 0){
            Toast.makeText(this, "请输入邮箱", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pwd == null || pwd.length() <= 0) {
            Toast.makeText(this,"请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    private void setListeners(){
        binding.textCreateNewAccount.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));

    }
}