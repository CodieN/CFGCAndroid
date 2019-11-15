package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProjectsActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_projects);
        Button btnHome = findViewById(R.id.homeButton5);
        Button btnBack = findViewById(R.id.backButton0);
        Button btnGrants = findViewById(R.id.grantsButton1);
        Button btnLegacy = findViewById(R.id.legacyButton1);
        TextView titleTV = findViewById(R.id.projectsLabelTextView);
        TextView descTV = findViewById(R.id.projectsInfoTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        Typeface fancy = Typeface.createFromAsset(getAssets(), "organic_elements.ttf");

        titleTV.setTypeface(fancy);
        descTV.setTypeface(arial);
        btnBack.setTypeface(fancy);
        btnGrants.setTypeface(fancy);
        btnLegacy.setTypeface(fancy);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ProjectsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ProjectsActivity.this, ImpactActivity.class);
                startActivity(i);
            }
        });

        btnGrants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ProjectsActivity.this, GrantsActivity.class);
                startActivity(i);
            }
        });

        btnLegacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ProjectsActivity.this, LegacyActivity.class);
                startActivity(i);
            }
        });
    }
}
