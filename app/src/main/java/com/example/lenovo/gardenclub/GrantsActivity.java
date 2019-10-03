package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
