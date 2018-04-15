package com.example.zaneta.igandroidapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private String[] arrayGroup ;
    private String[][] arrayChildren;
    private Context context;

     public ExpandableAdapter(Context context, String[] arrayGroup, String[][] arrayChildren){
        this.arrayGroup = arrayGroup;
        this.context = context;
        this.arrayChildren = arrayChildren;
     }




    @Override
    public int getGroupCount() {
        return arrayGroup.length;
    }

    @Override
    public int getChildrenCount(int childPosition) {
        return arrayChildren[0].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return arrayGroup[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arrayChildren[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View View, ViewGroup parent) {
        TextView txtView = new TextView(context);
        txtView.setText(arrayGroup[groupPosition]);

        txtView.setPadding(100,0,0,0);
        txtView.setTextSize(40);
        return txtView;
    }



    @Override
    public View getChildView( int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView txtView = new TextView(context);
        Log.d("MyApp",groupPosition + " " + childPosition);
        txtView.setText(arrayChildren[groupPosition][childPosition]);
        txtView.setPadding(10,0,0,0);
        txtView.setTextSize(30);
                    return txtView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
