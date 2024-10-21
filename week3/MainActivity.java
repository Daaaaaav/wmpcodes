package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDC, btnMarvel, btnBL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDC = findViewById(R.id.button1);
        btnMarvel = findViewById(R.id.button2);
        btnBL = findViewById(R.id.button3);

        btnDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView4, dc.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        btnMarvel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView4, marvel.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        btnBL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView4, bumilangit.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

    }
}
