package com.example.zaneta.igandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button UKbutton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UKbutton = (Button) findViewById(R.id.UKbutton);
        UKbutton.setOnClickListener((v) -> openSecondActivity());
    }

    public void openSecondActivity(){
        Intent intent = new Intent(this,ScrollingActivity.class);
        startActivity(intent);
    }
}
