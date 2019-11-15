package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LegacyActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lasting_legacy);
        Button btnHome = findViewById(R.id.homeButton7);
        Button btnProjects = findViewById(R.id.projectsButton2);
        Button btnGrants = findViewById(R.id.grantsButton2);
        Button btnBack = findViewById(R.id.backButton2);
        TextView titleTV = findViewById(R.id.legacyLabelTextView);
        TextView descTV = findViewById(R.id.endowmentHistoryTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        Typeface fancy = Typeface.createFromAsset(getAssets(), "organic_elements.ttf");

        titleTV.setTypeface(fancy);
        descTV.setTypeface(arial);
        btnProjects.setTypeface(fancy);
        btnGrants.setTypeface(fancy);
        btnBack.setTypeface(fancy);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(LegacyActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(LegacyActivity.this, ProjectsActivity.class);
                startActivity(i);
            }
        });

        btnGrants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(LegacyActivity.this, GrantsActivity.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(LegacyActivity.this, ImpactActivity.class);
                startActivity(i);
            }
        });
    }
}
