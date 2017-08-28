package com.example.lenovo.hyapp;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;

public class FirstpageActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        TabHost tabHost = getTabHost();

       tabHost.addTab(tabHost.newTabSpec("TAB1").setIndicator("",
                getResources().getDrawable(R.drawable.icon1)).setContent(new Intent().setClass(this,ShoppingActivity.class)));
         tabHost.addTab(tabHost.newTabSpec("TAB2").setIndicator("",
                getResources().getDrawable(R.drawable.icon3)).setContent(new Intent().setClass(this,FenleiActivity.class)));
       /* tabHost.addTab(tabHost.newTabSpec("TAB3").setIndicator("",
                getResources().getDrawable(R.drawable.icon4)).setContent(new Intent().setClass(this,ShoppingCarActivity.class)));*/
        tabHost.addTab(tabHost.newTabSpec("TAB4").setIndicator("",
                getResources().getDrawable(R.drawable.icon5)).setContent(new Intent().setClass(this,PersonalActivity.class)));
        int i;
        for (i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#ffffff"));

        }
    }
    }

