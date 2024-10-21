package com.example.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        String address = Preferences.getAddress(getBaseContext());
        String phoneNumber = Preferences.getPhoneNumber(getBaseContext());
        userInfo.setText("Name: " + username + "\nAddress: " + address + "\nPhone: " + phoneNumber);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        Preferences.clearUserInfo(getBaseContext());
        Intent intent = new Intent(MainActivity.this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
