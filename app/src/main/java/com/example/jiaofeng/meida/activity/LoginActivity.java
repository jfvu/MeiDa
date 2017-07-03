package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by jiaofeng on 2017/5/31.
 */

public class LoginActivity extends AutoLayoutActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView forgetPassword = (TextView)findViewById(R.id.tv_forget);
        TextView newLogin = (TextView)findViewById(R.id.tv_new);
        Button login = (Button)findViewById(R.id.but_login);
        EditText phoneNumber = (EditText)findViewById(R.id.et_phonenumber);
        EditText passWord = (EditText)findViewById(R.id.et_password);
        forgetPassword.setOnClickListener(this);
        newLogin.setOnClickListener(this);
        login.setOnClickListener(this);


        ImmersionBar.with(this).statusBarDarkFont(true).init();
        //设置系统栏透明，字体颜色为深色
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_forget:
                Intent intent = new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);

                break;
            case R.id.tv_new:
                Intent intent2 = new Intent(LoginActivity.this,Registeractivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.but_login:
                Intent intent1 = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
