package com.example.jiaofeng.meida.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class MessageDetailsActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ImageView imgBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messsagedetails);
        initview();

    }
    private void initview(){
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        imgBack = (ImageView) findViewById(R.id.img_back_messagedetails_activity);
        imgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_messagedetails_activity:
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
