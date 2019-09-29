package com.example.lenovo.gardenclub;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.SearchView;
import android.widget.Switch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ContactList extends AppCompatActivity {
    private List<Contacts> contacts = new ArrayList<>();
    private static final String TAG = "ContactList";
    String json_string, loginEmail;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapter nContactAdapter;
    Intent intent;
    public static AppCompatActivity fa;
    RecyclerView lst;
    Switch nameSortToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fa = this;
        setContentView(R.layout.activity_contact_list);
        intent = new Intent(this, Contact.class);

        JSONObject JO;

        lst = (RecyclerView) findViewById(R.id.ListView);
        nameSortToggle = findViewById(R.id.SortToggleSwitch);
        nameSortToggle.setEnabled(false);
        json_string = getIntent().getExtras().getString("json_data");
        loginEmail = getIntent().getExtras().getString("login_email").trim();
        intent.putExtra("json_data", json_string);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        nameSortToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    nameSortToggle.setText(R.string.sort_first);
                    Collections.sort(contacts, new Comparator<Contacts>() {
                        @Override
                        public int compare(Contacts c0, Contacts c1) {
                            String name0 = c0.getName();
                            String name1 = c1.getName();
                            String first0 = name0.substring(0, name0.indexOf(" "));
                            String first1 = name1.substring(0, name1.indexOf(" "));
                            int comp = first0.compareTo(first1);
                            if(comp != 0) {
                                return comp;
                            } else {
                                String last0 = name0.substring(name0.lastIndexOf(" ") + 1);
                                String last1 = name1.substring(name1.lastIndexOf(" ") + 1);
                                return last0.compareTo(last1);
                            }
                        }
                    });
                } else {
                    nameSortToggle.setText(R.string.sort_last);
                    Collections.sort(contacts, new Comparator<Contacts>() {
                        @Override
                        public int compare(Contacts c0, Contacts c1) {
                            String name0 = c0.getName();
                            String name1 = c1.getName();
                            String last0 = name0.substring(name0.lastIndexOf(" ") + 1);
                            String last1 = name1.substring(name1.lastIndexOf(" ") + 1);
                            int comp = last0.compareTo(last1);
                            if(comp != 0) {
                                return comp;
                            } else {
                                String first0 = name0.substring(0, name0.indexOf(" "));
                                String first1 = name1.substring(0, name1.indexOf(" "));
                                return first0.compareTo(first1);
                            }
                        }
                    });
                }
                lst.setLayoutManager(new LinearLayoutManager(ContactList.this));
                nContactAdapter = new ContactAdapter(ContactList.this, (ArrayList<Contacts>) contacts);
                lst.setAdapter(nContactAdapter);
            }
        });

        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int i = 0;
            String name, email, mobile, mbrStatus, userID, photoID;

            while(i < mJSONArray.length()) {
                JO = mJSONArray.getJSONObject(i);
                name = JO.getString("FirstName").concat(" " + JO.getString("LastName"));
                email = JO.getString("EmailAddress");
                mobile = JO.getString("PrimNum");
                mbrStatus = JO.getString("Status");
                userID = JO.getString("ID");
                photoID = JO.getString("PhotoID");
                Contacts contact = new Contacts(name, email, mobile, mbrStatus, userID, loginEmail, photoID);
                contacts.add(contact);
                i++;

            }
            Collections.sort(contacts, new Comparator<Contacts>() {
                @Override
                public int compare(Contacts c0, Contacts c1) {
                    String name0 = c0.getName();
                    String name1 = c1.getName();
                    String last0 = name0.substring(name0.lastIndexOf(" ") + 1);
                    String last1 = name1.substring(name1.lastIndexOf(" ") + 1);
                    int comp = last0.compareTo(last1);
                    if(comp != 0) {
                        return comp;
                    } else {
                        String first0 = name0.substring(0, name0.indexOf(" "));
                        String first1 = name1.substring(0, name1.indexOf(" "));
                        return first0.compareTo(first1);
                    }
                }
            });
            lst.setLayoutManager(new LinearLayoutManager(this));
            nContactAdapter = new ContactAdapter(this, (ArrayList<Contacts>) contacts);
            lst.setAdapter(nContactAdapter);
            nameSortToggle.setEnabled(true);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context
                .SEARCH_SERVICE);
        MenuItem menuItem = menu.findItem(R.id.search_badge_ID);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

//        additional features
        searchView.setActivated(true);
        searchView.setQueryHint("Search for a member");
        searchView.onActionViewExpanded();
        searchView.setIconified(false);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                nContactAdapter.getFilter().filter(s);
                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);
    }

}


