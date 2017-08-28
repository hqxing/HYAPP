package com.example.lenovo.hyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(3000); //停顿三秒
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent openCalculator=new Intent("example.lenovo.hyapp.FIRSTPAGE");
                    startActivity(openCalculator);
                }
            }
        };
        timer.start();
    }
    @Override//下面的代码是让程序直接退出，而不是返回上一个界面
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
