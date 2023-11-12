package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Lab3_1 extends AppCompatActivity {
    private ListView lvContact;
    GetContact getContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab31);

        lvContact=findViewById(R.id.lvbai1);

        getContact=new GetContact(this,lvContact);
        getContact.execute();
    }
}