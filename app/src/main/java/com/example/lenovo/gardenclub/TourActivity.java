package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TourActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azalea_garden_tour);
        Button btnHome = findViewById(R.id.homeButton1);
        Button btnMap = findViewById(R.id.mapButton);
        Button btnBelles = findViewById(R.id.bellesButton);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(TourActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This feature will be added in the near future.", Toast.LENGTH_SHORT).show();
            }
        });

        btnBelles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This feature will be added in the near future.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
