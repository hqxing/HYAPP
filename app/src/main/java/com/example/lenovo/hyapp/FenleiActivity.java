package com.example.lenovo.hyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FenleiActivity extends AppCompatActivity {
    ImageView iv_chunCai,iv_mianMo,iv_gongJu,iv_huFu,iv_xiangShui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei);
        iv_chunCai=(ImageView)findViewById(R.id.iv_chunCai);
        iv_mianMo=(ImageView)findViewById(R.id.iv_mianMo);
        iv_gongJu=(ImageView)findViewById(R.id.iv_gongJu);
        iv_huFu=(ImageView)findViewById(R.id.iv_huFu);
        iv_xiangShui=(ImageView)findViewById(R.id.iv_xiangShui);
    }

    //唇彩点击事件
    public void chuncaiOnClick(View view){
        Intent intent = new Intent(FenleiActivity.this,CaizhuangActivity.class);
        startActivity(intent);
    }
    public void huFuOnClick(View view){
        Intent intent = new Intent(FenleiActivity.this,HufuActivity.class);
        startActivity(intent);
    }

    public void goJuOnClick(View view){
        Intent intent = new Intent(FenleiActivity.this,GongjuActivity.class);
        startActivity(intent);
    }
    public void xiangShuiOnClick(View view){
        Intent intent = new Intent(FenleiActivity.this,XiangshuiActivity.class);
        startActivity(intent);
    }
}
