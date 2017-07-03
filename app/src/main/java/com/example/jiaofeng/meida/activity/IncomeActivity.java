package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

public class IncomeActivity extends AutoLayoutActivity implements View.OnClickListener{
    private TextView income;
    private Intent intent;
    private ImageView imgBack;
    private int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        initView();
        initEvent();
    }

    private void initEvent() {
        income.setOnClickListener(this);
        imgBack.setOnClickListener(this);
    }

    private void initView() {
        income= (TextView) findViewById(R.id.income);
        imgBack = (ImageView) findViewById(R.id.img_back_imcome_activity);
        intent = getIntent();
        a = intent.getIntExtra("income",0);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.income:
                startActivity(new Intent(this,RequestActivity.class));
                break;
            case R.id.img_back_imcome_activity:
                if (a == 1){
//finish();
                }
                else if (a == 2){

                }
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
