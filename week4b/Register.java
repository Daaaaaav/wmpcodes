package com.example.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText inputUsername, inputEmail, inputPhone, inputPassword, inputConfirmPassword;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputUsername = findViewById(R.id.username);
        inputEmail = findViewById(R.id.email);
        inputPhone = findViewById(R.id.phone);
        inputPassword = findViewById(R.id.password);
        inputConfirmPassword = findViewById(R.id.confirm_password);
        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inputUsername.getText().toString();
                String email = inputEmail.getText().toString();
                String phone = inputPhone.getText().toString();
                String password = inputPassword.getText().toString();
                String confirmPassword = inputConfirmPassword.getText().toString();
                if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(Register.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                Preferences.setUsername(getBaseContext(), username);
                Preferences.setPassword(getBaseContext(), password);
                Preferences.setEmail(getBaseContext(), email);
                Preferences.setPhone(getBaseContext(), phone);
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
