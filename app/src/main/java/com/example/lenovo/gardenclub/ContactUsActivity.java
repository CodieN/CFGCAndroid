package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ContactUsActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Button btnHome = findViewById(R.id.homeButton9);
        Button btnBack = findViewById(R.id.backButton3);
        Button btnMembersOnly = findViewById(R.id.membersOnlyButton1);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ContactUsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ContactUsActivity.this, MembershipActivity.class);
                startActivity(i);
            }
        });

        btnMembersOnly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ContactUsActivity.this, LoginProcess.class);
                startActivity(i);
            }
        });
    }
}
