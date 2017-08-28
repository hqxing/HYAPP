package com.example.lenovo.hyapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.hyapp.dataControl.DataBaseHelper;
import com.example.lenovo.hyapp.model.GoodsInfoList;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCarActivity extends AppCompatActivity {
    private ListView exListView;
    private CheckBox cb_check_all;
    private TextView tv_total_price;
    private TextView tv_delete;
    private TextView tv_go_to_pay;

    private Context context;
    DataBaseHelper dbHelper;
    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shopping_car);
        cb_check_all = (CheckBox) findViewById(R.id.all_chekbox);
        tv_total_price = (TextView) findViewById(R.id.tv_total_price);
        tv_delete = (TextView) findViewById(R.id.tv_delete);
        tv_go_to_pay = (TextView) findViewById(R.id.tv_go_to_pay);
        exListView = (ListView) findViewById(R.id.exListView);

    }
    /**
     * 统计操作<br>
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作<br>
     * 3.给底部的textView进行数据填充
     */
    private void calculate()
    {
        totalCount = 0;
        totalPrice = 0.00;
        ArrayList<GoodsInfoList> goodsInfoLists=new ArrayList<GoodsInfoList>();
        for (int i=0;i<goodsInfoLists.size();i++){
            GoodsInfoList goodsInfo=goodsInfoLists.get(i);
                totalCount++;
                totalPrice += goodsInfo.getPrice() * goodsInfo.getCount();
        }
        tv_total_price.setText("￥" + totalPrice);
        tv_go_to_pay.setText("去支付(" + totalCount + ")");
    }







}
