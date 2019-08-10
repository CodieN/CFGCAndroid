package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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