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

public class ChooseCountry extends AppCompatActivity {
    Button UKbutton, GERbutton,FRAbutton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_choose_country);
        UKbutton = (Button) findViewById(R.id.UKbutton);
        UKbutton.setOnClickListener((v) -> openUKactivity());

        GERbutton= (Button) findViewById(R.id.GERMANYbutton);
        GERbutton.setOnClickListener((v) -> openGERactivity());

        FRAbutton= (Button) findViewById(R.id.FRANCEbutton);
        FRAbutton.setOnClickListener((v) -> openFRAactivity());
    }

    public void openUKactivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void openGERactivity(){
        Intent intent = new Intent(this,ActivityGER.class);
        startActivity(intent);
    }
    public void openFRAactivity(){
        Intent intent = new Intent(this,ActivityFR.class);
        startActivity(intent);
    }
    }


