package com.example.lenovo.gardenclub;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MoreInfo extends AppCompatActivity {
    private static final String TAG = "MoreInfo";
    String userID, loginEmail, userEmail, firstName, lastName, bio;
    int viewId_placeholder = 0;
    StringBuilder str = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MoreInfo.class);
        intent.getExtras();
        userID = getIntent().getExtras().getString("user_id");
        loginEmail = getIntent().getExtras().getString("login_email").trim();
        userEmail = getIntent().getExtras().getString("user_email").trim();
        firstName = getIntent().getExtras().getString("firstName").trim();
        lastName = getIntent().getExtras().getString("lastName").trim();
        setContentView(R.layout.activity_more_info);
        getSupportActionBar().hide();

        JSONObject JO;

        String YTA = getIntent().getExtras().getString("YTA");
        bio = getIntent().getExtras().getString("bio");


        final TextView tvYTA = findViewById(R.id.tv_yta);
        final TextView tvBio = findViewById(R.id.tv_bio);
        TextView tvBack = findViewById(R.id.tvBack);
        tvYTA.setText(YTA);


        if (loginEmail.equals(userEmail)) {
            if (bio != null || bio != "null") {
                tvBio.setText(bio);
            } else {
                tvBio.setText(getApplicationContext().getString(R.string.userNoBio));
            }
            AlertDialog alertDialog = null;
            final AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(new ContextThemeWrapper(MoreInfo.this, R.style.myDialog));
            View viewAD = getLayoutInflater().inflate(R.layout.dialog_general, null);

            TextView tvEdit = findViewById(R.id.tvEdit);
            tvEdit.setText("Edit");
            final int tvYTAId = tvYTA.getId();
            final int tvBioId = tvBio.getId();
            final TextView adTitle = viewAD.findViewById(R.id.genTitle);
            final EditText etGen = viewAD.findViewById(R.id.etGen);
            builder.setView(viewAD)
                    .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (viewId_placeholder == tvBioId) {
                                String udBio = etGen.getText().toString();
                                tvBio.setText(udBio);
                                try {
                                    SaveData(userID,loginEmail,udBio);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                            if (viewId_placeholder == tvYTAId) {
                                //<------------------
                            }
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });

            tvEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Tap the fields you wish to change", Toast.LENGTH_LONG).show();
                }
            });

            alertDialog = builder.create();

            final AlertDialog finalAlertDialog = alertDialog;
            View.OnClickListener editFields = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int viewId = view.getId();

                    if (viewId == tvBioId) {
                        adTitle.setText("Edit Biographical Info");
                        viewId_placeholder = viewId;
                        finalAlertDialog.show();
                        etGen.setText(tvBio.getText());
                    }
                    if (viewId == tvYTAId) {
                        viewId_placeholder = viewId;
                        Toast.makeText(getApplicationContext(), "You cannot edit your Member Status from this application", Toast.LENGTH_LONG).show();
                    }
                }
            };

            tvBio.setOnClickListener(editFields);
            tvYTA.setOnClickListener(editFields);
        } else {
            if (bio.equals("null") || bio == null) {
                tvBio.setText(firstName + " has not added a bio yet.");
            } else {
                tvBio.setText(bio);
            }
        }

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public boolean SaveData(String uID, String email, String bio) throws InterruptedException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        final AlertDialog.Builder ad = new AlertDialog.Builder(getApplicationContext());

        ad.setTitle("Error! ");
        ad.setIcon(android.R.drawable.btn_star_big_on);
        ad.setPositiveButton("Close", null);

        String url = "http://capefeargardenclub.org/cfgcTestingJSON/update.php";
        params.add(new BasicNameValuePair("userID", uID));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("bio", bio));
        params.add(new BasicNameValuePair("bioUpdate", "yes"));

        String resultServer  = getHttpPost(url,params);

        /*** Default Value ***/
        String strStatusID = "0";
        String strMessage = "Unknown Status!";

        JSONObject c;
        try {
            c = new JSONObject(resultServer);
            strStatusID = c.getString("StatusID");
            strMessage = c.getString("Message");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Prepare Save Data
        if(strStatusID.equals("0")) {
            Toast.makeText(MoreInfo.this, getApplicationContext().getString(R.string.error_save), Toast.LENGTH_SHORT).show();

            return false;
        } else {
            Toast.makeText(MoreInfo.this, getApplicationContext().getString(R.string.succ_save), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public String getHttpPost(String strUrl, final List<NameValuePair> params) throws InterruptedException {
        final String url = strUrl;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                HttpClient client = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                str = new StringBuilder();

                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                    HttpResponse response = client.execute(httpPost);
                    StatusLine statusLine = response.getStatusLine();
                    int statusCode = statusLine.getStatusCode();
                    if (statusCode == 200) { // Status OK
                        HttpEntity entity = response.getEntity();
                        InputStream content = entity.getContent();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            str.append(line);
                        }
                    } else {
                        Log.e("Log", "Failed to download result..");
                    }
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        return str.toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Contact.class);
        intent.putExtra("user_id", userID);
        intent.putExtra("bio", bio);
        intent.putExtra("login_email", loginEmail);
        startActivity(intent);
        finish();
    }
}
