package com.example.lenovo.hyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {
    EditText edt_count;
    TextView tv_show,tv_momey;
    Button btn_countMoney;
    int count,intprice;
    String strCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        tv_show=(TextView) findViewById(R.id.tv_show);
        tv_momey=(TextView) findViewById(R.id.tv_momey);
        edt_count=(EditText)findViewById(R.id.edt_count);
        btn_countMoney=(Button)findViewById(R.id.btn_countMoney);


        Intent intent1=getIntent();
        Bundle bundle=intent1.getExtras();
        String goodsname=bundle.getString("goodsname");
        String goodsId=bundle.getString("goodsid");
        String price=bundle.getString("price");
        String type=bundle.getString("type");
        tv_show.setText(goodsId+"\n"+goodsname+"\n"+price+"\n"+type);
        intprice=Integer.parseInt(price);
        Log.i("intprice",intprice+"元");

    }

    public void countMoneyOnClick(View view){
        strCount=edt_count.getText().toString();
        Log.i("strCount",strCount+"元");

        // count=Integer.parseInt(strCount);
        count=Integer.valueOf(strCount).intValue();
        Log.i("count",count+"个");
        tv_momey.setText(count*intprice+"元");
    }
}
