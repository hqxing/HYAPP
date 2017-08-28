package com.example.lenovo.hyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lenovo.hyapp.adapter.ShoppingAdapter;
import com.example.lenovo.hyapp.dataControl.DataBaseHelper;
import com.example.lenovo.hyapp.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity {
    ImageView iv_hufu,iv_caizhuang,iv_gongju,iv_xiangshui;
    ListView lv_home;
    List<Goods> list,list1;
    Goods goods;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        iv_hufu= (ImageView) findViewById(R.id.iv_hufu);
        iv_caizhuang= (ImageView) findViewById(R.id.iv_caizhuang);
        iv_gongju= (ImageView) findViewById(R.id.iv_gongju);
        iv_xiangshui= (ImageView) findViewById(R.id.iv_xiangshui);

        lv_home=(ListView) findViewById(R.id.lv_home);
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
        ShoppingAdapter spAdapter=new ShoppingAdapter(this,list1);
        lv_home.setAdapter(spAdapter);


        iv_hufu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingActivity.this,HufuActivity.class);
                startActivity(intent);
            }

        });

        iv_caizhuang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingActivity.this,CaizhuangActivity.class);
                startActivity(intent);
            }

        });
        iv_gongju.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingActivity.this,GongjuActivity.class);
                startActivity(intent);
            }

        });
        iv_xiangshui.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingActivity.this,XiangshuiActivity.class);
                startActivity(intent);

            }

        });


    }
}
