package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class JoinDetailsActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ImageView imgBack;
    private Button butSubimt;
    private ImageView imgSend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joindetails);
        initview();
    }
    private void initview(){
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        imgBack = (ImageView) findViewById(R.id.img_back_joindetails_activity);
        butSubimt = (Button) findViewById(R.id.but_submit_joindetails_activity);
        imgSend = (ImageView) findViewById(R.id.img_send_joindetails_activity);
        imgBack.setOnClickListener(this);
        butSubimt.setOnClickListener(this);
        imgSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_joindetails_activity:
                finish();
                break;
            case R.id.img_send_joindetails_activity:
                break;
            case R.id.but_submit_joindetails_activity:
                Intent intent = new Intent(JoinDetailsActivity.this,TaskPassOrFailActivity.class);
                startActivity(intent);
                break;
        }
    }
}
