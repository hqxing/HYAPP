package com.example.lenovo.hyapp.model;

import android.graphics.Bitmap;

/**
 * Created by lenovo on 2017/6/15.
 */

public class GoodsInfoList {
    String goodsId;
    String goodsName;
    private int price;
    String type;
    Bitmap goodsImage;
    protected boolean isChoosed;
    private int count;
    private int position;// 绝对位置，只在ListView构造的购物车中，在删除时有效

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Bitmap getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(Bitmap goodsImage) {
        this.goodsImage = goodsImage;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getPosition() {return position;}

    public void setPosition(int position) {this.position = position;}

    public boolean isChoosed() {return isChoosed;}

    public void setChoosed(boolean isChoosed)
    {
        this.isChoosed = isChoosed;
    }

}