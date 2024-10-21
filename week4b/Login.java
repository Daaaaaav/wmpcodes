package com.example.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText inputUser, inputPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUser = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });
    }

    private void goLogin() {
        inputUser.setError(null);
        inputPassword.setError(null);
        boolean cancel = false;
        View focus = null;

        String username = inputUser.getText().toString();
        String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(username)) {
            inputUser.setError("This field is required");
            focus = inputUser;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            inputPassword.setError("This field is required");
            focus = inputPassword;
            cancel = true;
        }

        if (cancel) {
            focus.requestFocus();
        } else {
            if (Preferences.getUsername(getBaseContext()).equals(username) &&
                    Preferences.getPassword(getBaseContext()).equals(password)) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                inputUser.setError("Invalid username or password");
                inputPassword.setError("Invalid username or password");
            }
        }
    }
}
