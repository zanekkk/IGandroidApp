
package com.example.zaneta.igandroidapp;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.widget.ExpandableListView;


public class ScrollingActivityGER extends AppCompatActivity {
    private String URL = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/de_DE/dem";
    private ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("GERMANY MARKETS");
        setSupportActionBar(toolbar);
        listView = (ExpandableListView) findViewById(R.id.listView);
        ContentOfScrollActivity content = new ContentOfScrollActivity( URL, ScrollingActivityGER.this, (ExpandableListView) findViewById(R.id.listView));

        ExpandableAdapter expandableAdapter = new ExpandableAdapter(ScrollingActivityGER.this, content.groupArray, content.childArray);
        listView.setAdapter(expandableAdapter);

    }



}