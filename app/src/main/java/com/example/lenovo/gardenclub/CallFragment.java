package com.example.lenovo.gardenclub;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

public class CallFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        final String prim = getArguments().getString("prim");
        final String sec = getArguments().getString("sec");
        Button btnTextPrimary = view.findViewById(R.id.primaryButton);
        Button btnTextSec = view.findViewById(R.id.secondaryButton);
        if (prim != null && !prim.equals("null"))
            btnTextPrimary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel: " + prim));
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Intent otherCallIntent = new Intent(Intent.ACTION_DIAL);
                        otherCallIntent.setData(Uri.parse("tel: " + prim));
                        startActivity(otherCallIntent);
                        return;
                    }
                    startActivity(callIntent);
                }
            });
        if (sec != null && !sec.equals("null"))
            btnTextSec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel: " + sec));
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Intent otherCallIntent = new Intent(Intent.ACTION_DIAL);
                        otherCallIntent.setData(Uri.parse("tel: " + sec));
                        startActivity(otherCallIntent);
                        return;
                    }
                    startActivity(callIntent);
                }
            });
        return view;
    }
}
