package com.example.lenovo.hyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.hyapp.adapter.CaiZhuangAdapter;
import com.example.lenovo.hyapp.adapter.HuFuAdapter;
import com.example.lenovo.hyapp.dataControl.DataBaseHelper;
import com.example.lenovo.hyapp.model.Goods;

import java.util.ArrayList;
import java.util.List;


public class HufuActivity extends AppCompatActivity {
    ListView lv_hufu;
    List<Goods> list,list1;
    Goods goods;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hufu);

        lv_hufu=(ListView) findViewById(R.id.lv_hufu);
        dbHelper=new DataBaseHelper(this,1);
        dbHelper.getWritableDatabase();
        list=new ArrayList<>();
        list=dbHelper.queryHuFu();
        list1=new ArrayList<>();
        Log.i("a",list.size()+"");
        for (int i=0;i<list.size();i++){
            goods=list.get(i);
            goods.setGoodsId(goods.getGoodsId());
            goods.setGoodsName(goods.getGoodsName());
            goods.setType(goods.getType());
            goods.setPrice(goods.getPrice());
            list1.add(goods);
        }
        HuFuAdapter hfAdapter=new HuFuAdapter(this,list1);
        lv_hufu.setAdapter(hfAdapter);

    }
}