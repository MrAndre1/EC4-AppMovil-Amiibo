package com.andre.ec4;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();

        editTextEmail.setText("");
        editTextPassword.setText("");
    }
    private void validateLogin(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            editTextEmail.setError("Email is required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            editTextPassword.setError("Password is required");
            return;
        }
        if(email.equals("ejemplo@idat.edu.pe") && password.equals("1234567.")){
            Intent intent = new Intent(LoginActivity.this, AmiiboActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this,"Incorrect credentials",Toast.LENGTH_LONG).show();
        }
    }
}
