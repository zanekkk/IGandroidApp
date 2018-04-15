//Żaneta Cichoń April/2018

package com.example.zaneta.igandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

public class ActivityFR extends AppCompatActivity {
    private String URL = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/fr_FR/frm";
    private ExpandableListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fr);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("FRANCE MARKETS");
        setSupportActionBar(toolbar);
        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener((v) -> openCountryActivity());

        listView = (ExpandableListView) findViewById(R.id.listViewFR);
        ContentOfScrollActivity content = new ContentOfScrollActivity( URL, listView);

        ExpandableAdapter expandableAdapter = new ExpandableAdapter(ActivityFR.this, content.groupArray, content.childArray);
        listView.setAdapter(expandableAdapter);
    }

    public void openCountryActivity(){
        Intent intent = new Intent(this,ChooseCountry.class);
        startActivity(intent);
    }

}
