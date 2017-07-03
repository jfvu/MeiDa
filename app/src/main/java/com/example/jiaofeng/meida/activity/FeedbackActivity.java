package com.example.jiaofeng.meida.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

public class FeedbackActivity extends AutoLayoutActivity implements View.OnClickListener{
    private TextView tv_send;
    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initView();
        initEvent();
    }

    private void initEvent() {
        tv_send.setOnClickListener(this);
        imgback.setOnClickListener(this);
    }

    private void initView() {
        tv_send= (TextView) findViewById(R.id.tv_send);
        imgback = (ImageView) findViewById(R.id.img_back_feedback_activity);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_send:
                finish();
                break;
            case R.id.img_back_feedback_activity:
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
