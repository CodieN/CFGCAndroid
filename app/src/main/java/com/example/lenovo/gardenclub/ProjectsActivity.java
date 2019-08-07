package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
