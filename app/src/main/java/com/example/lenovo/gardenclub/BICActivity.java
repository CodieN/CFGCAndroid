package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BICActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_island_committee);
        Button btnHome = findViewById(R.id.homeButton3);
        Button btnBack = findViewById(R.id.backButton);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(BICActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(BICActivity.this, EventsActivity.class);
                startActivity(i);
            }
        });
    }
}
