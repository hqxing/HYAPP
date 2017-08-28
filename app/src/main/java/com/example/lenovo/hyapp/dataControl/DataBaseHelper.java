package com.example.lenovo.hyapp.dataControl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.lenovo.hyapp.model.Goods;
import com.example.lenovo.hyapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private Context mycontext;
    //数据库名
    private static final String DATABASENAME="hydatabase";
    //表名
    private static final String TABLE_USERS="users";
    private static final String TABLE_GOODS="goods";
    //users表字段名
    private static final String USER_ID="userid";
    private static final String USER_NAME="username";
    private static final String USER_PASSWORD="password";
    //goods表字段名
    private static final String GOODS_ID="goodsid";
    private static final String GOODS_NAME="goodsname";
    private static final String GOODS_PRICE="price";
    private static final String GOODS_TYPE="type";


    public DataBaseHelper(Context context,int version) {

        super(context, DATABASENAME, null, version);
        mycontext=context;
        Log.i("0","成功创建数据库");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String strCreateUsers="CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,userid INTEGER,username TEXT," +
                "password TEXT) ";
        db.execSQL(strCreateUsers);
        Log.i("1","成功创建数据表users");

        String strCreateGoods="CREATE TABLE goods(id INTEGER PRIMARY KEY AUTOINCREMENT,goodsid TEXT,goodsname TEXT,"+
                "type TEXT,price INTEGER) ";
        db.execSQL(strCreateGoods);
        Log.i("2","成功创建数据表goods");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //添加数据到商品表
    public void addDataToGoods(Goods goods){
        //读写数据库
        SQLiteDatabase db=getWritableDatabase();
        //用ContentValues类包装数据
        ContentValues valuesGoods=new ContentValues();
        valuesGoods.put(GOODS_ID,goods.getGoodsId());
        valuesGoods.put(GOODS_NAME,goods.getGoodsName());
       // valuesGoods.put(GOODS_PRODUCTION,goods.getGoodsProduction());
        valuesGoods.put(GOODS_PRICE,goods.getPrice());
        valuesGoods.put(GOODS_TYPE,goods.getType());
        //插入数据
        try{
            long flag=db.insert(TABLE_GOODS,null,valuesGoods);
            if (flag> 0) {
                Log.i("3.1", "成功往goods表中添加第" + flag+ "条记录！");
            } else if (flag == -1){
                Log.i("3.1", "数据添加失败！");
            }
        }catch (Exception e){
        Toast.makeText(mycontext, "系统异常，请联系管理员！", Toast.LENGTH_LONG).show();
        Log.i("3.2", "系统异常，请联系管理员");
        }
        finally {
        db.close();
        }
    }
    //添加数据到用户表
    public void addDataToUser(User user){
        //读写数据库
        SQLiteDatabase db=getWritableDatabase();
        //用ContentValues类包装数据
        ContentValues valuesUser=new ContentValues();
        valuesUser.put(USER_ID,user.getUserId());
        valuesUser.put(USER_NAME,user.getUserNmae());
        valuesUser.put(USER_PASSWORD,user.getUserPassword());
        //valuesUser.put(USER_EMAIL,user.getEmail());
        //插入数据
        try {
            long flag = db.insert(TABLE_USERS,null,valuesUser);
            if (flag> 0) {
                Log.i("4.1", "成功往users表中添加第"+ flag + "条记录！");
            } else if (flag == -1){
                Toast.makeText(mycontext, "数据添加失败！", Toast.LENGTH_LONG).show();
                Log.i("4.2", "数据添加失败！");
            }
        }catch (Exception e)
        {
            Toast.makeText(mycontext, "系统异常，请联系管理员！", Toast.LENGTH_LONG).show();
            Log.i("5", "系统异常，请联系管理员");
        }
        finally {
            db.close();
        }
    }

    //查询5条数据
    public List<Goods> queryfive() {
        List<Goods> goodsList=new ArrayList<Goods>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("select * from goods order by id DESC limit0,5",null);
            Log.i("2.9","成功查询数据表goods");
            while (cursor.moveToNext()) {
                Goods goods = new Goods();
                goods.setGoodsId(cursor.getString(cursor.getColumnIndex("goodsid")));
                goods.setGoodsName(cursor.getString(cursor.getColumnIndex("goodsname")));
                goods.setType(cursor.getString(cursor.getColumnIndex("type")));
                goods.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                Log.i("2.9.1","成功查询数据");
                goodsList.add(goods);
            }
            return goodsList;
        } catch (Exception e) {
            Toast.makeText(mycontext, "系统异常，请联系管理员", Toast.LENGTH_LONG).show();
        } finally {
            db.close();
        }
        return null;
    }
    //查询彩妆数据
    public List<Goods> queryCaiZhuang() {
        List<Goods> goodsList=new ArrayList<Goods>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("select * from goods where type='唇彩' order by id DESC",null);
            Log.i("2.9","成功查询数据表goods");
            while (cursor.moveToNext()) {
                Goods goods = new Goods();
                goods.setGoodsId(cursor.getString(cursor.getColumnIndex("goodsid")));
                goods.setGoodsName(cursor.getString(cursor.getColumnIndex("goodsname")));
                goods.setType(cursor.getString(cursor.getColumnIndex("type")));
                goods.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                Log.i("2.9.1","成功查询数据");
                goodsList.add(goods);
            }
            return goodsList;
        } catch (Exception e) {
            Toast.makeText(mycontext, "系统异常，请联系管理员", Toast.LENGTH_LONG).show();
        } finally {
            db.close();
        }
        return null;
    }
    //查询工具数据
    public List<Goods> queryGongJu() {
        List<Goods> goodsList=new ArrayList<Goods>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("select * from goods where type='工具' order by id DESC",null);
            Log.i("2.9","成功查询数据表goods");
            while (cursor.moveToNext()) {
                Goods goods = new Goods();
                goods.setGoodsId(cursor.getString(cursor.getColumnIndex("goodsid")));
                goods.setGoodsName(cursor.getString(cursor.getColumnIndex("goodsname")));
                goods.setType(cursor.getString(cursor.getColumnIndex("type")));
                goods.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                Log.i("2.9.1","成功查询数据");
                goodsList.add(goods);
            }
            return goodsList;
        } catch (Exception e) {
            Toast.makeText(mycontext, "系统异常，请联系管理员", Toast.LENGTH_LONG).show();
        } finally {
            db.close();
        }
        return null;
    }
    //查询香水数据
    public List<Goods> queryXiangShui() {
        List<Goods> goodsList=new ArrayList<Goods>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("select * from goods where type='香水' order by id DESC",null);
            Log.i("2.9","成功查询数据表goods");
            while (cursor.moveToNext()) {
                Goods goods = new Goods();
                goods.setGoodsId(cursor.getString(cursor.getColumnIndex("goodsid")));
                goods.setGoodsName(cursor.getString(cursor.getColumnIndex("goodsname")));
                goods.setType(cursor.getString(cursor.getColumnIndex("type")));
                goods.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                Log.i("2.9.1","成功查询数据");
                goodsList.add(goods);
            }
            return goodsList;
        } catch (Exception e) {
            Toast.makeText(mycontext, "系统异常，请联系管理员", Toast.LENGTH_LONG).show();
        } finally {
            db.close();
        }
        return null;
    }
    //查询护肤数据
    public List<Goods> queryHuFu() {
        List<Goods> goodsList=new ArrayList<Goods>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("select * from goods where type='护肤' order by id DESC",null);
            Log.i("2.9","成功查询数据表goods");
            while (cursor.moveToNext()) {
                Goods goods = new Goods();
                goods.setGoodsId(cursor.getString(cursor.getColumnIndex("goodsid")));
                goods.setGoodsName(cursor.getString(cursor.getColumnIndex("goodsname")));
                goods.setType(cursor.getString(cursor.getColumnIndex("type")));
                goods.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                Log.i("2.9.1","成功查询数据");
                goodsList.add(goods);
            }
            return goodsList;
        } catch (Exception e) {
            Toast.makeText(mycontext, "系统异常，请联系管理员", Toast.LENGTH_LONG).show();
        } finally {
            db.close();
        }
        return null;
    }

    //查询用户
    public List<User> queryallUser() {
        List<User> userList=new ArrayList<User>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("select * from users order by id DESC",null);
            Log.i("qU","成功查询数据表users");
            while (cursor.moveToNext()) {
                User user = new User();
                user.setUserId(cursor.getInt(cursor.getColumnIndex("userid")));
                user.setUserNmae(cursor.getString(cursor.getColumnIndex("username")));
                user.setUserPassword(cursor.getString(cursor.getColumnIndex("password")));

                Log.i("qU1","成功查询数据");
                userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            Toast.makeText(mycontext, "系统异常，请联系管理员", Toast.LENGTH_LONG).show();
        } finally {
            db.close();
        }
        return null;
    }
}
