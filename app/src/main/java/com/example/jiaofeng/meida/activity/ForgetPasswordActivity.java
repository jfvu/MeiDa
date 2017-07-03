package com.example.jiaofeng.meida.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by jiaofeng on 2017/5/31.
 */

public class ForgetPasswordActivity extends AutoLayoutActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        Button getCode = (Button)findViewById(R.id.but_getcode_change);
        Button finish = (Button)findViewById(R.id.but_finish_change);
        EditText phoneNumber = (EditText)findViewById(R.id.et_phonenumber_change);
        EditText code = (EditText)findViewById(R.id.et_getcode_change);
        EditText password = (EditText)findViewById(R.id.et_password_change);
        finish.setOnClickListener(this);
        getCode.setOnClickListener(this);

        ImmersionBar.with(this).statusBarDarkFont(true).init();
        //设置系统栏透明，字体颜色为深色
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_finish_change:
                finish();
                break;
            case R.id.but_getcode_change:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
