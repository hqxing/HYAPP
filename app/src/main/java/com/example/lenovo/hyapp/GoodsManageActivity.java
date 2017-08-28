package com.example.lenovo.hyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.hyapp.dataControl.DataBaseHelper;
import com.example.lenovo.hyapp.model.Goods;

public class GoodsManageActivity extends AppCompatActivity {
    EditText manage_edt_goodid,manage_edt_goodname,manage_edt_price,manage_edt_type;
    Button btn_manage_addfoods,btn_manage_clearfoods,btn_manage_okAddfoods;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_manage);
        manage_edt_goodid= (EditText) findViewById(R.id.manage_edt_goodid);
        manage_edt_goodname= (EditText) findViewById(R.id.manage_edt_goodname);
        manage_edt_price= (EditText) findViewById(R.id.manage_edt_price);
        manage_edt_type= (EditText) findViewById(R.id.manage_edt_type);
        btn_manage_addfoods= (Button) findViewById(R.id.btn_manage_addfoods);
        btn_manage_clearfoods= (Button) findViewById(R.id.btn_manage_clearfoods);
        btn_manage_okAddfoods= (Button) findViewById(R.id.btn_manage_okAddfoods);

        dbHelper=new DataBaseHelper(this,1);
        dbHelper.getWritableDatabase();
    }
    //点击添加商品按钮
    public void addGoodsOnClick(View view){
        String goodsId=manage_edt_goodid.getText().toString();
        String goodsName=manage_edt_goodname.getText().toString();
        String price=manage_edt_price.getText().toString();
        String type=manage_edt_type.getText().toString();
        Goods goods=new Goods();
        goods.setGoodsId(goodsId);
        goods.setGoodsName(goodsName);
        goods.setType(type);
        goods.setPrice(Integer.valueOf(price));
        dbHelper.addDataToGoods(goods);
        Log.i("a","添加数据进goods表");
    }

    //点击清除按钮
    public void clearGoodsOnClick(View view){
        manage_edt_goodid.setText("");
        manage_edt_goodname.setText("");
        manage_edt_price.setText("");
        manage_edt_type.setText("");
    }

    //点击完成添加按钮，跳转到彩妆商品页面
    public void okAddGoodsOnClick(View view){
        String type=manage_edt_type.getText().toString();
        switch (type){
            case "唇彩":
                Intent intent=new Intent(this,CaizhuangActivity.class);
                startActivity(intent);
                break;
            case "护肤":
                Intent intent1=new Intent(this,HufuActivity.class);
                startActivity(intent1);
                break;
            case "香水":
                Intent intent2=new Intent(this,XiangshuiActivity.class);
                startActivity(intent2);
                break;
            case "工具":
                Intent intent3=new Intent(this,GongjuActivity.class);
                startActivity(intent3);
                break;
        }

    }
}
