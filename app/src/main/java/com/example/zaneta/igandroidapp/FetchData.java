//Żaneta Cichoń April/2018

package com.example.zaneta.igandroidapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,String> {
    private String data = "", dataParsed = "", singleParsed = "";
    private String URL;
    private String elements ;
    private String text;

    public FetchData(String URL,String elements, String text){
        this.URL = URL;
        this.elements = elements;
        this.text = text;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL(URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while(line != null){
                line = bufferedReader.readLine();
                data += line;
            }

            JSONObject JS = new JSONObject(data);
            JSONArray JSarray = JS.getJSONArray("markets");


            for(int i = 0; i < JSarray.length(); i++) {
                JSONObject JSobject = (JSONObject) JSarray.get(i);
                singleParsed = text + JSobject.get(elements) + "\n";
                dataParsed += singleParsed;
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataParsed;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }}