package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jiaofeng.meida.R;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by jiaofeng on 2017/6/5.
 */

public class SucceedActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ImageView imgBack;
    private Button butFinish;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succeed);
        imgBack = (ImageView) findViewById(R.id.img_back_succeed_activity);
        butFinish = (Button) findViewById(R.id.but_finish_succeed);
        imgBack.setOnClickListener(this);
        butFinish.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_succeed_activity:
                finish();
                break;
            case R.id.but_finish_succeed:
                startActivity(new Intent(SucceedActivity.this, WithdrawActivity.class));
                finish();
                break;
        }
    }
}
