package com.example.jiaofeng.meida.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.view.PopWin1;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

public class ShareActivity extends AutoLayoutActivity implements View.OnClickListener{
    private TextView submit;
    private ImageView imgBack;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initView();
        initEvent();
    }

    private void initEvent() {
        submit.setOnClickListener(this);
        imgBack.setOnClickListener(this);
    }

    private void initView() {
        submit= (TextView) findViewById(R.id.submit);
        imgBack = (ImageView) findViewById(R.id.img_back_shareactivity);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }
    public void showPopFormBottom() {
        PopWin1 popWin1 = new PopWin1(this, onClickListener);
        //showAtLocation(View parent, int gravity, int x, int y)
        popWin1.showAtLocation(findViewById(R.id.main_view), Gravity.CENTER, 0, 0);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
intent = new Intent(getBaseContext(),ExperienceActivity.class);
            switch (v.getId()) {
                case R.id.qq:
                    Toast.makeText(getApplicationContext(),"QQ",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                    break;
                case R.id.weixin:
                    Toast.makeText(getApplicationContext(),"微信",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                    break;
                case R.id.weibo:
                    Toast.makeText(getApplicationContext(),"微博",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                showPopFormBottom();
                break;
            case R.id.img_back_shareactivity:
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
