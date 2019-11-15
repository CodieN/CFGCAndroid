package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TourActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azalea_garden_tour);
        Button btnHome = findViewById(R.id.homeButton1);
        Button btnMap = findViewById(R.id.mapButton0);
        Button btnBelles = findViewById(R.id.bellesButton0);
        TextView titleTV = findViewById(R.id.tourLabelTextView);
        TextView tourDescTV = findViewById(R.id.tourDescriptionTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        Typeface fancy = Typeface.createFromAsset(getAssets(), "organic_elements.ttf");

        titleTV.setTypeface(fancy);
        tourDescTV.setTypeface(arial);
        btnMap.setTypeface(fancy);
        btnBelles.setTypeface(fancy);

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
                i = new Intent(TourActivity.this, MapActivity.class);
                startActivity(i);
            }
        });

        btnBelles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(TourActivity.this, BellesActivity.class);
                startActivity(i);
            }
        });
    }
}
