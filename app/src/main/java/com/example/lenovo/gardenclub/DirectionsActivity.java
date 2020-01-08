package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;

public class DirectionsActivity extends AppCompatActivity {
    private Intent i;
    private Uri uri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);
        String marker = getIntent().getStringExtra("marker");
        Button btnHome = findViewById(R.id.homeButton12);
        TextView titleTV = findViewById(R.id.titleTV);
        TextView descTV = findViewById(R.id.descriptionTV);
        TextView dLabel = findViewById(R.id.dLabel);
        ImageView garden = findViewById(R.id.gardenIV);
        Button btnF = findViewById(R.id.fButton);
        Button btnS = findViewById(R.id.sButton);
        Button btnBack = findViewById(R.id.backButton);
        Guideline g8 = findViewById(R.id.guideline8);
        Guideline g10 = findViewById(R.id.guideline10);
        ConstraintSet cs = new ConstraintSet();
        ConstraintLayout cL = findViewById(R.id.cL);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");

        titleTV.setTypeface(arial);
        descTV.setTypeface(arial);
        dLabel.setTypeface(arial);
        btnF.setTypeface(arial);
        btnS.setTypeface(arial);
        btnBack.setTypeface(arial);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(DirectionsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(DirectionsActivity.this, MapActivity.class);
                startActivity(i);
            }
        });

        switch(marker) {
            case "RC":
                titleTV.setText(R.string.about);
                descTV.setText(R.string.rc_marker);
                garden.setImageResource(R.drawable.ribboncutting);
                g8.setGuidelinePercent(0.83f);
                g10.setGuidelinePercent(0.59f);
                btnF.setText(R.string.get_directions_to_ribbon_cutting_opens_google_maps);
                btnF.setTextSize(18.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=314+Pine+Grove+Drive+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "1":
                titleTV.setText(R.string.about1);
                descTV.setText(R.string.marker_1);
                garden.setImageResource(R.drawable.garden1);
                g8.setGuidelinePercent(0.78f);
                g10.setGuidelinePercent(0.55f);
                cs.clone(cL);
                cs.clear(btnF.getId(), ConstraintSet.END);
                cs.clear(btnF.getId(), ConstraintSet.TOP);
                cs.clear(btnF.getId(), ConstraintSet.START);
                cs.setVisibility(dLabel.getId(), ConstraintSet.VISIBLE);
                cs.setVisibility(btnS.getId(), ConstraintSet.VISIBLE);
                cs.connect(btnF.getId(), ConstraintSet.TOP, dLabel.getId(), ConstraintSet.BOTTOM, 8);
                cs.connect(btnF.getId(), ConstraintSet.END, R.id.guideline12, ConstraintSet.START, 8);
                cs.connect(btnF.getId(), ConstraintSet.START, cL.getId(), ConstraintSet.START, 8);
                cs.applyTo(cL);
                btnF.setText(R.string.friday);
                dLabel.setText(R.string.get_directions_to_marker_1);
                btnS.setText(R.string.saturday_sunday);
                btnF.setTextSize(22.0f);
                dLabel.setTextSize(22.0f);
                btnS.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=314+Pine+Grove+Drive+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                btnS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=6211+Greenville+Loop+Road+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "2":
                titleTV.setText(R.string.about2);
                descTV.setText(R.string.marker_2);
                garden.setImageResource(R.drawable.garden2);
                g8.setGuidelinePercent(0.78f);
                g10.setGuidelinePercent(0.55f);
                cs.clone(cL);
                cs.clear(btnF.getId(), ConstraintSet.END);
                cs.clear(btnF.getId(), ConstraintSet.TOP);
                cs.clear(btnF.getId(), ConstraintSet.START);
                cs.setVisibility(dLabel.getId(), ConstraintSet.VISIBLE);
                cs.setVisibility(btnS.getId(), ConstraintSet.VISIBLE);
                cs.connect(btnF.getId(), ConstraintSet.TOP, dLabel.getId(), ConstraintSet.BOTTOM, 8);
                cs.connect(btnF.getId(), ConstraintSet.END, R.id.guideline12, ConstraintSet.START, 8);
                cs.connect(btnF.getId(), ConstraintSet.START, cL.getId(), ConstraintSet.START, 8);
                cs.applyTo(cL);
                btnF.setText(R.string.friday);
                dLabel.setText(getString(R.string.get_directions_to_marker_2));
                btnS.setText(R.string.saturday_sunday);
                btnF.setTextSize(22.0f);
                dLabel.setTextSize(22.0f);
                btnS.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=314+Pine+Grove+Drive+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                btnS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=6211+Greenville+Loop+Road+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "3":
                titleTV.setText(R.string.about3);
                descTV.setText(R.string.marker_3);
                garden.setImageResource(R.drawable.garden3);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_3);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=300+Airlie+Road+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "4":
                titleTV.setText(R.string.about4);
                descTV.setText(R.string.marker_4);
                garden.setImageResource(R.drawable.garden4);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_4);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=Seawater+Lane+Wrightsville+Beach,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "5":
                titleTV.setText(R.string.about5);
                descTV.setText(R.string.marker_5);
                garden.setImageResource(R.drawable.garden5);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_5);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=6309+Pintail+Court+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "6":
                titleTV.setText(R.string.about6);
                descTV.setText(R.string.marker_6);
                garden.setImageResource(R.drawable.garden6);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_6);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=707+Colonial+Drive+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "7":
                titleTV.setText(R.string.about7);
                descTV.setText(R.string.marker_7);
                garden.setImageResource(R.drawable.garden7);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_7);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=314+Colonial+Drive+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "8":
                titleTV.setText(R.string.about8);
                descTV.setText(R.string.marker_8);
                garden.setImageResource(R.drawable.garden8);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_8);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=1710+Chestnut+Street+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "9":
                titleTV.setText(R.string.about9);
                descTV.setText(R.string.marker_9);
                garden.setImageResource(R.drawable.garden9);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_9);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=1708+Chestnut+Street+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "10":
                titleTV.setText(R.string.about10);
                descTV.setText(R.string.marker_10);
                garden.setImageResource(R.drawable.garden10);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_10);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=1711+Princess+Street+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "11":
                titleTV.setText(R.string.about11);
                descTV.setText(R.string.marker_11);
                garden.setImageResource(R.drawable.garden11a);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_11);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=512+Grace+Street+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            case "12":
                titleTV.setText(R.string.about12);
                descTV.setText(R.string.marker_12);
                garden.setImageResource(R.drawable.garden12);
                g8.setGuidelinePercent(0.84f);
                g10.setGuidelinePercent(0.60f);
                btnF.setText(R.string.get_directions_to_marker_12);
                btnF.setTextSize(22.0f);
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=5024+Split+Rail+Drive+Wilmington,+North+Carolina&mode=d");
                        i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        if(i.resolveActivity(getPackageManager()) != null)
                            startActivity(i);
                    }
                });
                break;
            default:
                break;
        }
    }
}
