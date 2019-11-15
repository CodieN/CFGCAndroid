package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        TextView titleTV = findViewById(R.id.committeeLabelTextView);
        TextView descTV = findViewById(R.id.committeeInfoTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");

        titleTV.setTypeface(arial);
        descTV.setTypeface(arial);
        btnBack.setTypeface(arial);

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
