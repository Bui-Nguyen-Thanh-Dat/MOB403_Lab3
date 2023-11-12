package com.example.lab3;

import android.app.ProgressDialog;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.lab3.bai4.ApiService;
import com.example.lab3.bai4.ContactList;
import com.example.lab3.bai4.Contact;
import com.example.lab3.bai4.InternetConnection;
import com.example.lab3.bai4.MyContactAdapter;
import com.example.lab3.bai4.RetroClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Lab3_4 extends AppCompatActivity {
    private ListView listView;
    private View parentView;
    private ArrayList<Contact> contactList;
    private MyContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab34);
        contactList = new ArrayList<>();
        parentView = findViewById(R.id.parentLayout);
        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(parentView, contactList.get(position).getName() + " => " + contactList.get(position).getPhone().getHome(),Snackbar.LENGTH_LONG).show();
                                                    }
                                                });

        FloatingActionButton fab = (FloatingActionButton)
                findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if
                (InternetConnection.checkConnection(getApplicationContext())) {
                    final ProgressDialog dialog;
                    dialog = new ProgressDialog(Lab3_4.this);
                    dialog.setTitle(getString(R.string.app_name));
                    dialog.setMessage(getString(R.string.app_name));
                    dialog.show();

                    ApiService api = RetroClient.getApiService();

                    Call<ContactList> call = api.getMyJSON();

                    call.enqueue(new Callback<ContactList>() {
                        @Override
                        public void onResponse(Call<ContactList> call, Response<ContactList> response) {

                            dialog.dismiss();
                            if(response.isSuccessful()) {

                                contactList = response.body().getContacts();

                                adapter = new MyContactAdapter(Lab3_4.this, contactList);
                                listView.setAdapter(adapter);
                            } else {
                                Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<ContactList> call, Throwable t) {
                            dialog.dismiss();
                        }
                    });
                } else {
                    Snackbar.make(parentView, R.string.string_internet_connection_not_available,
                            Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

}