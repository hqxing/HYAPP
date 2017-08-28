package com.example.lenovo.hyapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.hyapp.ContentActivity;
import com.example.lenovo.hyapp.R;
import com.example.lenovo.hyapp.model.Goods;

import java.util.List;

public class XiangShuiAdapter extends BaseAdapter {
    Context mContext;
    List<Goods> mData;
    public XiangShuiAdapter(Context mContext, List mData) {
        this.mContext = mContext;
        this.mData = mData;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(mContext, R.layout.cai_zhuang_item,null);
        final TextView tv_caiZhuangName=(TextView) view.findViewById(R.id.tv_caiZhuangName);
        final TextView tv_caiZhuangId=(TextView) view.findViewById(R.id.tv_caiZhuangId);
        final TextView tv_type=(TextView) view.findViewById(R.id.tv_type);
        final TextView tv_price=(TextView) view.findViewById(R.id.tv_price);
        ImageView ig_caiZhuang=(ImageView) view.findViewById(R.id.ig_caiZhuang);
        ImageView ig_shopCar=(ImageView) view.findViewById(R.id.ig_shopCar);

            Goods goods = mData.get(position);
                tv_caiZhuangName.setText(goods.getGoodsName());
                tv_caiZhuangId.setText(goods.getGoodsId());
                tv_type.setText(goods.getType());
                String onePrice = "" + goods.getPrice();
                tv_price.setText(onePrice);

        switch (goods.getGoodsId()){
            case "xs001":
                ig_caiZhuang.setImageResource(R.drawable.xs001);
                break;
            case "xs002":
                ig_caiZhuang.setImageResource(R.drawable.xs002);
                break;
            case "xs003":
                ig_caiZhuang.setImageResource(R.drawable.xs003);
                break;
            case "xs004":
                ig_caiZhuang.setImageResource(R.drawable.xs004);
                break;
        }
        ig_shopCar.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick(View v) {
              Intent intent=new Intent();
              Bundle bundle=new Bundle();
              bundle.putString("goodsname",tv_caiZhuangName.getText().toString());
              bundle.putString("goodsid",tv_caiZhuangId.getText().toString());
              bundle.putString("price",tv_price.getText().toString());
              bundle.putString("type",tv_type.getText().toString());
              intent.putExtras(bundle);
              intent.setClass(mContext,ContentActivity.class);
              mContext.startActivity(intent);
          }
        });

            return view;


    }
}
