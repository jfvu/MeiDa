package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

public class SetActivity extends AutoLayoutActivity implements View.OnClickListener{
    private RelativeLayout rel_feedback;
    private ImageView imgBack;
    private TextView tvLogoff;
    private RelativeLayout relAbout;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
        initEvent();
    }

    private void initEvent() {

    }

    private void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        rel_feedback= (RelativeLayout) findViewById(R.id.rel_feedback);
        rel_feedback.setOnClickListener(this);
        relAbout = (RelativeLayout) findViewById(R.id.rel_about_set_activity);
        relAbout.setOnClickListener(this);
        imgBack = (ImageView) findViewById(R.id.img_back_set_activity);
        imgBack.setOnClickListener(this);
        tvLogoff = (TextView) findViewById(R.id.tv_logoff_set_activity);
        tvLogoff.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rel_feedback:
                startActivity(new Intent(this,FeedbackActivity.class));
                break;
            case R.id.rel_about_set_activity:
                intent = new Intent(SetActivity.this,AboutActicity.class);
                startActivity(intent);
                break;
            case R.id.img_back_set_activity:
                finish();
                break;
            case R.id.tv_logoff_set_activity:
                intent = new Intent(SetActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
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
