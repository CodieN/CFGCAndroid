package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GrantsActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grants);
        Button btnHome = findViewById(R.id.homeButton6);
        Button btnProjects = findViewById(R.id.projectsButton1);
        Button btnBack = findViewById(R.id.backButton1);
        Button btnLegacy = findViewById(R.id.legacyButton2);
        TextView titleTV = findViewById(R.id.grantsLabelTextView);
        TextView descTV = findViewById(R.id.grantInfoTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        Typeface fancy = Typeface.createFromAsset(getAssets(), "organic_elements.ttf");

        titleTV.setTypeface(fancy);
        descTV.setTypeface(arial);
        btnProjects.setTypeface(fancy);
        btnBack.setTypeface(fancy);
        btnLegacy.setTypeface(fancy);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(GrantsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(GrantsActivity.this, ProjectsActivity.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(GrantsActivity.this, ImpactActivity.class);
                startActivity(i);
            }
        });

        btnLegacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(GrantsActivity.this, LegacyActivity.class);
                startActivity(i);
            }
        });
    }
}
