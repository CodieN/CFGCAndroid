package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventsActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Button btnHome = findViewById(R.id.homeButton2);
        Button btnBIC = findViewById(R.id.batteryIslandCommitteeButton);
        TextView titleTV = findViewById(R.id.eventsLabelTextView);
        TextView descTV = findViewById(R.id.cruiseDescriptionTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        Typeface fancy = Typeface.createFromAsset(getAssets(), "organic_elements.ttf");

        titleTV.setTypeface(fancy);
        descTV.setTypeface(arial);
        btnBIC.setTypeface(fancy);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(EventsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnBIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(EventsActivity.this, BICActivity.class);
                startActivity(i);
            }
        });
    }
}
