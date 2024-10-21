package com.example.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView userInfo;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInfo = findViewById(R.id.user_info);
        btnLogout = findViewById(R.id.btn_logout);
        String username = Preferences.getUsername(getBaseContext());
        String email = Preferences.getEmail(getBaseContext());
        String phone = Preferences.getPhone(getBaseContext());
        userInfo.setText("Username: " + username + "\nEmail: " + email + "\nPhone: " + phone);
        btnLogout.setOnClickListener(v -> {
            Preferences.clearUserInfo(getBaseContext());
            Intent intent = new Intent(MainActivity.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
