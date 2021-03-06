//Żaneta Cichoń April/2018

package com.example.zaneta.igandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;

public class ContentOfScrollActivity extends AppCompatActivity {
    public static String instrumentData = null, versionData = null, periodData = null, epicData = null, exchangeIdData = null, bidData = null, displayOffer = null, timeData = null ;
    public static String data = null;
    public ExpandableListView listView;
    public String[] groupArray, versionArray,periodArray, epicArray,exchangeArray, bidArray,offerArray,timeArray ;
    public String[][] childArray ;



    public ContentOfScrollActivity(String URL, ExpandableListView listView){
        this.listView = listView;


        try {
            instrumentData = new FetchData(URL, "instrumentName","").execute().get();
            versionData= new FetchData(URL, "instrumentVersion","Version: ").execute().get();
            periodData= new FetchData(URL, "displayPeriod","Period: ").execute().get();
            epicData= new FetchData(URL, "epic","Epic: ").execute().get();
            exchangeIdData= new FetchData(URL, "exchangeId","Exchange ID: ").execute().get();
            bidData= new FetchData(URL, "displayBid","BID: ").execute().get();
            displayOffer= new FetchData(URL, "displayOffer","Offer: ").execute().get();
            timeData= new FetchData(URL, "updateTime","Update time: ").execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        groupArray = instrumentData.split("\n");
        setArrays();

    }


    public void setArrays(){
        groupArray = instrumentData.split("\n");
        childArray = new String[groupArray.length][8];

        versionArray = versionData.split("\n");
        periodArray = periodData.split("\n");
        epicArray = epicData.split("\n");
        exchangeArray = exchangeIdData.split("\n");
        bidArray = bidData.split("\n");
        offerArray = displayOffer.split("\n");
        timeArray = timeData.split("\n");


        for(int i = 0; i < groupArray.length ; i++){

            childArray[i][0] = groupArray[i];
            childArray[i][1] = versionArray[i];
            childArray[i][2] = periodArray[i];
            childArray[i][3] = epicArray[i];
            childArray[i][4] = exchangeArray[i];
            childArray[i][5] = bidArray[i];
            childArray[i][6] = offerArray[i];
            childArray[i][7] = timeArray[i];
        }

        Arrays.sort(groupArray);
        Arrays.sort(childArray, new ColumnComparator(0));


    }

    class ColumnComparator implements Comparator {
        int columnToSort;
        ColumnComparator(int columnToSort) {
            this.columnToSort = columnToSort;
        }
        public int compare(Object o1, Object o2) {
            String[] row1 = (String[]) o1;
            String[] row2 = (String[]) o2;
            return row1[columnToSort].compareTo(row2[columnToSort]);
        }


}}