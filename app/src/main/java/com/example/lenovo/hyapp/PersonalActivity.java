package com.example.lenovo.hyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonalActivity extends AppCompatActivity {
    ImageView iv_guanli,iv_denglu,iv_zhuce;
    TextView tv_showUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        tv_showUserName= (TextView) findViewById(R.id.tv_showUserName);
        iv_guanli= (ImageView) findViewById(R.id.iv_guanli);
        iv_denglu= (ImageView) findViewById(R.id.iv_denglu);
        iv_zhuce= (ImageView) findViewById(R.id.iv_zhuce);

    }
   public void toManageGoodsClick(View view){
        Intent intent=new Intent(PersonalActivity.this,GoodsManageActivity.class);
        startActivity(intent);
    }
    public void toDengLuClick(View view){
        Intent intent=new Intent(PersonalActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    public void toZhuCeClick(View view){
        Intent intent=new Intent(PersonalActivity.this,Sign_upActivity.class);
        startActivity(intent);
    }
}
