package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Button btnHome = findViewById(R.id.homeButton11);
        Button btnBelles = findViewById(R.id.bellesButton1);
        Button btnTour = findViewById(R.id.tourButton0);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MapActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnBelles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MapActivity.this, BellesActivity.class);
                startActivity(i);
            }
        });

        btnTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MapActivity.this, TourActivity.class);
                startActivity(i);
            }
        });

        SupportMapFragment mapFrag = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.map, mapFrag).commit();
        mapFrag.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng latLng0 = new LatLng(34.191113, -77.838259);
                LatLng latLng1 = new LatLng(34.191070, -77.835086);
                LatLng latLng2 = new LatLng(34.191914, -77.837565);
                LatLng latLng3 = new LatLng(34.214952, -77.828157);
                LatLng latLng4 = new LatLng(34.239208, -77.943111);
                LatLng latLng5 = new LatLng(34.239137, -77.926989);
                LatLng latLng6 = new LatLng(34.239108, -77.927202);
                LatLng latLng7 = new LatLng(34.238595, -77.926464);
                LatLng latLng8 = new LatLng(34.228586, -77.912327);
                LatLng latLng9 = new LatLng(34.234054, -77.912885);
                LatLng latLng10 = new LatLng(34.151580, -77.902439);
                LatLng latLng11 = new LatLng(34.233283, -77.852662);
                LatLng latLng12 = new LatLng(34.215712, -77.807243);
                googleMap.addMarker(new MarkerOptions().position(latLng0).title(""));
                googleMap.addMarker(new MarkerOptions().position(latLng1));
                googleMap.addMarker(new MarkerOptions().position(latLng2));
                googleMap.addMarker(new MarkerOptions().position(latLng3));
                googleMap.addMarker(new MarkerOptions().position(latLng4));
                googleMap.addMarker(new MarkerOptions().position(latLng5));
                googleMap.addMarker(new MarkerOptions().position(latLng6));
                googleMap.addMarker(new MarkerOptions().position(latLng7));
                googleMap.addMarker(new MarkerOptions().position(latLng8));
                googleMap.addMarker(new MarkerOptions().position(latLng9));
                googleMap.addMarker(new MarkerOptions().position(latLng10));
                googleMap.addMarker(new MarkerOptions().position(latLng11));
                googleMap.addMarker(new MarkerOptions().position(latLng12));
                float zoomLevel = 16.0f;
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng0, zoomLevel));
                GoogleMapOptions gMO = new GoogleMapOptions();
                gMO.zoomGesturesEnabled(true);
            }
        });
    }
}
