package com.example.lenovo.gardenclub;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TextFragment extends Fragment {
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
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setData(Uri.parse("sms: " + prim));
                    startActivity(sendIntent);
                }
            });
        if (sec != null && !sec.equals("null"))
            btnTextSec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setData(Uri.parse("sms: " + sec));
                    startActivity(sendIntent);
                }
            });
        return view;
    }
}
