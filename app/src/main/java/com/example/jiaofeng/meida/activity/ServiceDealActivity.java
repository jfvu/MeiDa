package com.example.jiaofeng.meida.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by jiaofeng on 2017/6/3.
 */

public class ServiceDealActivity extends AutoLayoutActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicedeal);

        ImmersionBar.with(this).statusBarDarkFont(true).init();

        ImageView imgBack = (ImageView) findViewById(R.id.img_back_servicedeal);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title_servicedeal);


        imgBack.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_servicedeal:
                finish();
                break;
        }
    }
    private int getStatusBarHeight() {
        Resources resources = getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen","android");
        int height = resources.getDimensionPixelSize(resourceId);
        Log.v("dbw", "Status height:" + height);
        return height;
    }
}
