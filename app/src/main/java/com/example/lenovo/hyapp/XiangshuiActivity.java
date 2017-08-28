package com.example.lenovo.hyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.lenovo.hyapp.adapter.HuFuAdapter;
import com.example.lenovo.hyapp.adapter.XiangShuiAdapter;
import com.example.lenovo.hyapp.dataControl.DataBaseHelper;
import com.example.lenovo.hyapp.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class XiangshuiActivity extends AppCompatActivity {
    ListView lv_xiangshui;
    List<Goods> list,list1;
    Goods goods;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangshui);

        lv_xiangshui=(ListView) findViewById(R.id.lv_xiangshui);
        dbHelper=new DataBaseHelper(this,1);
        dbHelper.getWritableDatabase();
        list=new ArrayList<>();
        list=dbHelper.queryXiangShui();
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
        XiangShuiAdapter xsAdapter=new XiangShuiAdapter(this,list1);
        lv_xiangshui.setAdapter(xsAdapter);

    }
}
