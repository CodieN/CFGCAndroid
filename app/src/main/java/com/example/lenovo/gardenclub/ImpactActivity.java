package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImpactActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civic_impact);
        Button btnHome = findViewById(R.id.homeButton4);
        Button btnProjects = findViewById(R.id.projectsButton0);
        Button btnGrants = findViewById(R.id.grantsButton0);
        Button btnLegacy = findViewById(R.id.legacyButton0);
        TextView titleTV = findViewById(R.id.impactLabelTextView);
        TextView descTV = findViewById(R.id.clubThemeTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        Typeface fancy = Typeface.createFromAsset(getAssets(), "organic_elements.ttf");

        titleTV.setTypeface(fancy);
        descTV.setTypeface(arial);
        btnProjects.setTypeface(fancy);
        btnGrants.setTypeface(fancy);
        btnLegacy.setTypeface(fancy);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ImpactActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ImpactActivity.this, ProjectsActivity.class);
                startActivity(i);
            }
        });

        btnGrants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ImpactActivity.this, GrantsActivity.class);
                startActivity(i);
            }
        });

        btnLegacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ImpactActivity.this, LegacyActivity.class);
                startActivity(i);
            }
        });
    }
}
