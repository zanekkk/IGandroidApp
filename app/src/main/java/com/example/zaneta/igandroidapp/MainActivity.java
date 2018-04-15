//Żaneta Cichoń April/2018

package com.example.zaneta.igandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {
    private String URL = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/en_GB/igi";
    private ExpandableListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("UK MARKETS");
//        setSupportActionBar(toolbar);
        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener((v) -> openCountryActivity());

        listView = (ExpandableListView) findViewById(R.id.listViewUK);
        ContentOfScrollActivity content = new ContentOfScrollActivity(URL, listView);

        ExpandableAdapter expandableAdapter = new ExpandableAdapter(MainActivity.this, content.groupArray, content.childArray);
        listView.setAdapter(expandableAdapter);
    }

    public void openCountryActivity(){
        Intent intent = new Intent(this,ChooseCountry.class);
        startActivity(intent);
    }
}