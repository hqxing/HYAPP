package com.example.lenovo.hyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.hyapp.dataControl.DataBaseHelper;
import com.example.lenovo.hyapp.model.User;

public class LoginActivity extends AppCompatActivity {
    EditText edt_userId, edt_password;
    Button btn_login,btn_clear;
    DataBaseHelper dbHelper;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_userId = (EditText) findViewById(R.id.edt_userId);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        dbHelper=new DataBaseHelper(this,1);
        dbHelper.getWritableDatabase();

    }
    //点击登录按钮
    public void loginOnClick(View view){
        String strName=edt_userId.getText().toString();
        if (strName!=null) {
            dbHelper.queryallUser();
            String userName=user.getUserNmae();
            if (strName.equals(userName)){
                Intent intent=new Intent(LoginActivity.this,PersonalActivity.class);
                startActivity(intent);
                Log.i("isUser","用户存在");
            }else {
                btn_login.setEnabled(false);
            }
        }else {
            btn_login.setEnabled(false);
        }

    }
    //点击清空按钮
    public void clearOnClick(View view){
        edt_userId.setText("");
        edt_password.setText("");
    }

}