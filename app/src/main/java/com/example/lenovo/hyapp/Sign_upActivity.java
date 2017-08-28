package com.example.lenovo.hyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.lenovo.hyapp.dataControl.DataBaseHelper;
import com.example.lenovo.hyapp.model.User;

public class Sign_upActivity extends AppCompatActivity {
    EditText edt_uId,edt_uname,edt_upw1,edt_upw2;
    CheckBox ck_xieyi;
    Button btn_signUp;
    DataBaseHelper dbHelper;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edt_uId = (EditText) findViewById(R.id.edt_uId);
        edt_uname = (EditText) findViewById(R.id.edt_uname);
        edt_upw1 = (EditText) findViewById(R.id.edt_upw1);
        edt_upw2 = (EditText) findViewById(R.id.edt_upw2);
        ck_xieyi = (CheckBox) findViewById(R.id.ck_xieyi);
        btn_signUp= (Button) findViewById(R.id.btn_signUp);

        dbHelper=new DataBaseHelper(this,1);
        dbHelper.getWritableDatabase();

    }

    //点击注册按钮
    public void addUserOnClick(View view){
        String userId=edt_uId.getText().toString();
        String userName=edt_uname.getText().toString();
        String upw1=edt_upw1.getText().toString();
        String upw2=edt_upw2.getText().toString();
        User user=new User();
        user.setUserId(Integer.valueOf(userId));
        user.setUserNmae(userName);
        user.setUserPassword(upw1);
        user.setUserRePw(upw2);
        dbHelper.addDataToUser(user);
        Log.i("a","添加数据进goods表");
        Intent intent=new Intent(Sign_upActivity.this,PersonalActivity.class);
        startActivity(intent);
    }


}
