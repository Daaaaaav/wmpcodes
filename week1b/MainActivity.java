package com.example.greetingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button myButton;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        myButton = findViewById(R.id.button);
        title = findViewById(R.id.textView);
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inputName = editText.getText().toString();
                Toast.makeText(MainActivity.this, "Welcome " + inputName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

