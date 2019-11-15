package com.example.lenovo.gardenclub;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

public class MapActivity extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Button btnHome = findViewById(R.id.homeButton11);
        Button btnBelles = findViewById(R.id.bellesButton1);
        Button btnTour = findViewById(R.id.tourButton0);
        TextView titleTV = findViewById(R.id.mapLabelTextView);

        Typeface fancy = Typeface.createFromAsset(getAssets(), "organic_elements.ttf");

        titleTV.setTypeface(fancy);
        btnTour.setTypeface(fancy);
        btnBelles.setTypeface(fancy);

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
                LatLng latLngRC = new LatLng(34.191113, -77.838259);
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
                IconGenerator icRC = new IconGenerator(getApplicationContext());
                IconGenerator ic1 = new IconGenerator(getApplicationContext());
                IconGenerator ic2 = new IconGenerator(getApplicationContext());
                IconGenerator ic3 = new IconGenerator(getApplicationContext());
                IconGenerator ic4 = new IconGenerator(getApplicationContext());
                IconGenerator ic5 = new IconGenerator(getApplicationContext());
                IconGenerator ic6 = new IconGenerator(getApplicationContext());
                IconGenerator ic7 = new IconGenerator(getApplicationContext());
                IconGenerator ic8 = new IconGenerator(getApplicationContext());
                IconGenerator ic9 = new IconGenerator(getApplicationContext());
                IconGenerator ic10 = new IconGenerator(getApplicationContext());
                IconGenerator ic11 = new IconGenerator(getApplicationContext());
                IconGenerator ic12 = new IconGenerator(getApplicationContext());
                Bitmap bmpRC = icRC.makeIcon("RC");
                Bitmap bmp1 = ic1.makeIcon("1");
                Bitmap bmp2 = ic2.makeIcon("2");
                Bitmap bmp3 = ic3.makeIcon("3");
                Bitmap bmp4 = ic4.makeIcon("4");
                Bitmap bmp5 = ic5.makeIcon("5");
                Bitmap bmp6 = ic6.makeIcon("6");
                Bitmap bmp7 = ic7.makeIcon("7");
                Bitmap bmp8 = ic8.makeIcon("8");
                Bitmap bmp9 = ic9.makeIcon("9");
                Bitmap bmp10 = ic10.makeIcon("10");
                Bitmap bmp11 = ic11.makeIcon("11");
                Bitmap bmp12 = ic12.makeIcon("12");
                googleMap.addMarker(new MarkerOptions().position(latLngRC).title("RC").icon(BitmapDescriptorFactory.fromBitmap(bmpRC)));
                googleMap.addMarker(new MarkerOptions().position(latLng1).title("1").icon(BitmapDescriptorFactory.fromBitmap(bmp1)));
                googleMap.addMarker(new MarkerOptions().position(latLng2).title("2").icon(BitmapDescriptorFactory.fromBitmap(bmp2)));
                googleMap.addMarker(new MarkerOptions().position(latLng3).title("3").icon(BitmapDescriptorFactory.fromBitmap(bmp3)));
                googleMap.addMarker(new MarkerOptions().position(latLng4).title("4").icon(BitmapDescriptorFactory.fromBitmap(bmp4)));
                googleMap.addMarker(new MarkerOptions().position(latLng5).title("5").icon(BitmapDescriptorFactory.fromBitmap(bmp5)));
                googleMap.addMarker(new MarkerOptions().position(latLng6).title("6").icon(BitmapDescriptorFactory.fromBitmap(bmp6)));
                googleMap.addMarker(new MarkerOptions().position(latLng7).title("7").icon(BitmapDescriptorFactory.fromBitmap(bmp7)));
                googleMap.addMarker(new MarkerOptions().position(latLng8).title("8").icon(BitmapDescriptorFactory.fromBitmap(bmp8)));
                googleMap.addMarker(new MarkerOptions().position(latLng9).title("9").icon(BitmapDescriptorFactory.fromBitmap(bmp9)));
                googleMap.addMarker(new MarkerOptions().position(latLng10).title("10").icon(BitmapDescriptorFactory.fromBitmap(bmp10)));
                googleMap.addMarker(new MarkerOptions().position(latLng11).title("11").icon(BitmapDescriptorFactory.fromBitmap(bmp11)));
                googleMap.addMarker(new MarkerOptions().position(latLng12).title("12").icon(BitmapDescriptorFactory.fromBitmap(bmp12)));
                float zoomLevel = 16.0f;
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngRC, zoomLevel));
                GoogleMapOptions gMO = new GoogleMapOptions();
                gMO.mapToolbarEnabled(false);
                gMO.zoomGesturesEnabled(true);
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Intent i = new Intent(MapActivity.this, DirectionsActivity.class);
                        i.putExtra("marker", marker.getTitle());
                        startActivity(i);
                        return false;
                    }
                });
            }
        });
    }
}
