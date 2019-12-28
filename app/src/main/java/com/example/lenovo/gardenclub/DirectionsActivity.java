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
        ImageView garden = findViewById(R.id.gardenIV);
        Button btnGetDir = findViewById(R.id.getDirectionsButton);
        Button btnBack = findViewById(R.id.backButton);

        Typeface arial = Typeface.createFromAsset(getAssets(), "arial.ttf");

        titleTV.setTypeface(arial);
        descTV.setTypeface(arial);
        btnGetDir.setTypeface(arial);
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
                descTV.setText(R.string.rc_marker);
                garden.setImageResource(R.drawable.ribboncutting);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=6417+Quail+Run+Road+Wilmington,+North+Carolina&mode=d");
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
                btnGetDir.setText(R.string.get_directions_to_marker_1);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=6315+Old+Military+Road+Wilmington,+North+Carolina&mode=d");
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
                btnGetDir.setText(R.string.get_directions_to_marker_2);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=6451+Quail+Run+Road+Wilmington,+North+Carolina&mode=d");
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
                btnGetDir.setText(R.string.get_directions_to_marker_3);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
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
                btnGetDir.setText(R.string.get_directions_to_marker_4);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=510+Grace+Street+Wilmington,+North+Carolina&mode=d");
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
                btnGetDir.setText(R.string.get_directions_to_marker_5);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
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
            case "6":
                titleTV.setText(R.string.about6);
                descTV.setText(R.string.marker_6);
                garden.setImageResource(R.drawable.garden6);
                btnGetDir.setText(R.string.get_directions_to_marker_6);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
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
            case "7":
                titleTV.setText(R.string.about7);
                descTV.setText(R.string.marker_7);
                garden.setImageResource(R.drawable.garden7);
                btnGetDir.setText(R.string.get_directions_to_marker_7);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
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
            case "8":
                titleTV.setText(R.string.about8);
                descTV.setText(R.string.marker_8);
                garden.setImageResource(R.drawable.garden8);
                btnGetDir.setText(R.string.get_directions_to_marker_8);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
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
            case "9":
                titleTV.setText(R.string.about9);
                descTV.setText(R.string.marker_9);
                garden.setImageResource(R.drawable.garden9);
                btnGetDir.setText(R.string.get_directions_to_marker_9);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
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
            case "10":
                titleTV.setText(R.string.about10);
                descTV.setText(R.string.marker_10);
                garden.setImageResource(R.drawable.garden10);
                btnGetDir.setText(R.string.get_directions_to_marker_10);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=5024+Split+Rail+Road+Wilmington,+North+Carolina&mode=d");
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
                btnGetDir.setText(R.string.get_directions_to_marker_11);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=6309+Pin+Tail+Court+Wilmington,+North+Carolina&mode=d");
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
                btnGetDir.setText(R.string.get_directions_to_marker_12);
                btnGetDir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uri = Uri.parse("google.navigation:q=34.215712,-77.807243&mode=d");
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
