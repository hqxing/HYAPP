package com.example.lenovo.hyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.lenovo.hyapp.adapter.CaiZhuangAdapter;
import com.example.lenovo.hyapp.dataControl.DataBaseHelper;
import com.example.lenovo.hyapp.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class CaizhuangActivity extends AppCompatActivity {
    ListView lv_caiZhuang;
    List<Goods> list,list1;
    Goods goods;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caizhuang);

        lv_caiZhuang=(ListView) findViewById(R.id.lv_caiZhuang);
        dbHelper=new DataBaseHelper(this,1);
        dbHelper.getWritableDatabase();
        list=new ArrayList<>();
        list=dbHelper.queryCaiZhuang();
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
        CaiZhuangAdapter czAdapter=new CaiZhuangAdapter(this,list1);
        lv_caiZhuang.setAdapter(czAdapter);

    }
}
