package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EventsActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Button btnHome = findViewById(R.id.homeButton2);
        Button btnBIC = findViewById(R.id.batteryIslandCommitteeButton);

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
