package com.example.zaneta.igandroidapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    @Override
    protected Void doInBackground(Void... voids) {
    try {
        URL url = new URL("https://api.ig.com/deal/samples/markets/ANDROID_PHONE/en_GB/igi");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
        while(line != null){

            line = bufferedReader.readLine();
            data = data + line;
        }
    } catch (MalformedURLException e){
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ScrollingActivity.data.setText(this.data);
    }
}
