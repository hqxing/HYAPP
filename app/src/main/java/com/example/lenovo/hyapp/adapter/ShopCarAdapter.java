package com.example.lenovo.hyapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.hyapp.R;
import com.example.lenovo.hyapp.model.GoodsInfoList;

import java.util.List;

/**
 * Created by lenovo on 2017/6/18.
 */

public class ShopCarAdapter extends BaseAdapter {
    Context myContext;
    List<GoodsInfoList> mData;
    public ShopCarAdapter(Context mContext, List mData) {
        this.myContext = mContext;
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
        View view=View.inflate(myContext, R.layout.item_shopcart_product,null);
        ImageView iv_adapter_list_pic=(ImageView) view.findViewById(R.id.iv_adapter_list_pic);
        TextView tv_goodsInfoName=(TextView) view.findViewById(R.id.tv_goodsInfoName);
        TextView tv_goodsInfoId=(TextView) view.findViewById(R.id.tv_goodsInfoId);
        TextView tv_goodsInfoType=(TextView) view.findViewById(R.id.tv_goodsInfoType);
        TextView tv_price=(TextView) view.findViewById(R.id.tv_price);
        TextView tv_reduce=(TextView) view.findViewById(R.id.tv_reduce);
        TextView tv_num=(TextView) view.findViewById(R.id.tv_num);
        TextView tv_add=(TextView) view.findViewById(R.id.tv_add);
        GoodsInfoList goodsInfoList=mData.get(position);
        tv_goodsInfoName.setText(goodsInfoList.getGoodsName());
        tv_goodsInfoId.setText(goodsInfoList.getGoodsId());
        tv_goodsInfoType.setText(goodsInfoList.getType());
        tv_price.setText("￥" + goodsInfoList.getPrice() + "");
        iv_adapter_list_pic.setImageBitmap(goodsInfoList.getGoodsImage());

        return view;
    }
}
