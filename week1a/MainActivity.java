package com.example.week1a;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView nameTextView, studentIdTextView, emailTextView, majorTextView, addressTextView, dobTextView, hobbiesTextView;
    private ImageView profileImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTextView = findViewById(R.id.name);
        studentIdTextView = findViewById(R.id.stdid);
        emailTextView = findViewById(R.id.email);
        majorTextView = findViewById(R.id.major);
        addressTextView = findViewById(R.id.address);
        dobTextView = findViewById(R.id.dateofbirth);
        hobbiesTextView = findViewById(R.id.hobbies);
        profileImageView = findViewById(R.id.profile_picture);
        nameTextView.setText("Davina");
        studentIdTextView.setText("Student ID: your_studentid");
        emailTextView.setText("Email: your_email@example.com");
        majorTextView.setText("Major: Computer Science");
        addressTextView.setText("Address: Your Address");
        dobTextView.setText("Date of Birth: DD/MM/YYYY");
        hobbiesTextView.setText("Hobbies: Reading, Coding");
        profileImageView.setImageResource(R.drawable.whatsapp_image_2024_10_08_at_21_29_02_c60f2c1d);
    }
}
