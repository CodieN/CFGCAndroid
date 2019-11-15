package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MembershipActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        Button btnHome = findViewById(R.id.homeButton8);
        Button btnContact = findViewById(R.id.contactUsButton);
        Button btnMembersOnly = findViewById(R.id.membersOnlyButton0);
        TextView titleTV = findViewById(R.id.membershipLabelTextView);
        TextView descTV = findViewById(R.id.historyAndPurposeTextView);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");

        titleTV.setTypeface(arial);
        descTV.setTypeface(arial);
        btnContact.setTypeface(arial);
        btnMembersOnly.setTypeface(arial);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MembershipActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MembershipActivity.this, ContactUsActivity.class);
                startActivity(i);
            }
        });

        btnMembersOnly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MembershipActivity.this, LoginProcess.class);
                startActivity(i);
            }
        });
    }
}
