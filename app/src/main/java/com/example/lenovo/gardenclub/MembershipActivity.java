package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MembershipActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        Button btnHome = findViewById(R.id.homeButton8);
        Button btnContact = findViewById(R.id.contactUsButton);
        Button btnMembersOnly = findViewById(R.id.membersOnlyButton0);

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
