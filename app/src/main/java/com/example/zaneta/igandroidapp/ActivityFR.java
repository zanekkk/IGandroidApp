package com.example.zaneta.igandroidapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

public class ActivityFR extends AppCompatActivity {
    private String URL = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/fr_FR/frm";
    private ExpandableListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fr);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("FRANCE MARKETS");
        setSupportActionBar(toolbar);


        listView = (ExpandableListView) findViewById(R.id.listViewFR);
        ContentOfScrollActivity content = new ContentOfScrollActivity( URL, listView);

        ExpandableAdapter expandableAdapter = new ExpandableAdapter(ActivityFR.this, content.groupArray, content.childArray);
        listView.setAdapter(expandableAdapter);
    }

}
