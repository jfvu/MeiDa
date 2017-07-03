package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

public class RequestActivity extends AutoLayoutActivity implements View.OnClickListener{
    private TextView next;
    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        initView();
        initEvent();
    }

    private void initEvent() {
        next.setOnClickListener(this);
        imgback.setOnClickListener(this);
    }

    private void initView() {
        next= (TextView) findViewById(R.id.next);
        imgback = (ImageView) findViewById(R.id.img_back_requestactivity);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next:
                startActivity(new Intent(this,SetPasswordActivity.class));
                finish();
                break;
            case R.id.img_back_requestactivity:
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
