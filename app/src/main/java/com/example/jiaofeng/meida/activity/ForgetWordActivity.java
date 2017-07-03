package com.example.jiaofeng.meida.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by Administrator on 2017/6/21 0021.
 */

public class ForgetWordActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView tvFinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetword);
        imgBack = (ImageView) findViewById(R.id.img_back_forgetword_activity);
        tvFinish = (TextView) findViewById(R.id.next_forgetwordactivity);
        imgBack.setOnClickListener(this);
        tvFinish.setOnClickListener(this);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_forgetword_activity:
                finish();
                break;
            case R.id.next_forgetwordactivity:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
