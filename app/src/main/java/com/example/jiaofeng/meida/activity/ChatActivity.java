package com.example.jiaofeng.meida.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

public class ChatActivity extends AutoLayoutActivity implements View.OnClickListener{
private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
imgBack = (ImageView) findViewById(R.id.img_back_chat_activity);
        imgBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_chat_activity:
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
