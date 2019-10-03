package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BellesActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belles);
        Button btnHome = findViewById(R.id.homeButton12);
        Button btnMap = findViewById(R.id.mapButton1);
        Button btnTour = findViewById(R.id.tourButton1);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(BellesActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(BellesActivity.this, MapActivity.class);
                startActivity(i);
            }
        });

        btnTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(BellesActivity.this, TourActivity.class);
                startActivity(i);
            }
        });
    }
}
