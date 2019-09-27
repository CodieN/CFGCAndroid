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
import android.widget.SearchView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fa = this;
        setContentView(R.layout.activity_contact_list);
        intent = new Intent(this, Contact.class);

        JSONObject JO;
        lst = (RecyclerView) findViewById(R.id.ListView);

        json_string = getIntent().getExtras().getString("json_data");
        loginEmail = getIntent().getExtras().getString("login_email").trim();
        intent.putExtra("json_data", json_string);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

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
            for(int n = 1; n < contacts.size(); n++) {
                String name0 = contacts.get(n - 1).getName();
                String name1 = contacts.get(n).getName();
                String first0 = name0.substring(0, name0.indexOf(" "));
                String last0 = name0.substring(name0.indexOf(" ") + 1);
                String first1 = name1.substring(0, name1.indexOf(" "));
                String last1 = name1.substring(name1.indexOf(" ") + 1);
                if(last0.equals(last1)) {
                    int m = 0;
                    if(first0.length() > first1.length() || first0.length() == first1.length()) {
                        while(m < first1.length()) {
                            char letter0 = first0.charAt(m);
                            char letter1 = first1.charAt(m);
                            if(letter0 > letter1) {
                                contacts.add(n - 1, contacts.get(n));
                                contacts.remove(n + 1);
                                m = first1.length();
                            } else if(letter1 > letter0)
                                m = first1.length();
                            else
                                m++;
                        }
                    } else {
                        while(m < first0.length()) {
                            char letter0 = first0.charAt(m);
                            char letter1 = first1.charAt(m);
                            if(letter0 > letter1) {
                                contacts.add(n - 1, contacts.get(n));
                                contacts.remove(n + 1);
                                m = first0.length();
                            } else if(letter1 > letter0)
                                m = first0.length();
                            else
                                m++;
                        }
                    }
                }
            }
            lst.setLayoutManager(new LinearLayoutManager(this));
            nContactAdapter = new ContactAdapter(this, (ArrayList<Contacts>) contacts);
            lst.setAdapter(nContactAdapter);

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


