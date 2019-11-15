package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContactUsActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Button btnHome = findViewById(R.id.homeButton9);
        Button btnBack = findViewById(R.id.backButton3);
        Button btnMembersOnly = findViewById(R.id.membersOnlyButton1);
        TextView titleTV = findViewById(R.id.contactLabelTextView);
        TextView descTV = findViewById(R.id.contactInfoTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");
        Typeface fancy = Typeface.createFromAsset(getAssets(), "organic_elements.ttf");

        titleTV.setTypeface(fancy);
        descTV.setTypeface(arial);
        btnBack.setTypeface(fancy);
        btnMembersOnly.setTypeface(fancy);

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
