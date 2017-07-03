package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.view.PopWin2;
import com.example.jiaofeng.meida.view.PopWin3;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

public class Withdraw2Activity extends AutoLayoutActivity implements View.OnClickListener{

    private TextView next;
    private ImageView imgback;
    private Intent intent;
    private PopWin2 popWin2;
    private ImageView imgMenu;
    private PopWin3 popWin3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw2);
        initView();
        initEvent();
    }

    private void initEvent() {
        next.setOnClickListener(this);
        imgback.setOnClickListener(this);
        imgMenu.setOnClickListener(this);
    }

    private void initView() {
        next= (TextView) findViewById(R.id.next);
        imgback = (ImageView) findViewById(R.id.img_back_withdraw2_activity);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        imgMenu = (ImageView) findViewById(R.id.img_menu_withdraw2_activity);
    }
    public void showPopFormBottom() {
        popWin2 = new PopWin2(this, onClickListener);
        //showAtLocation(View parent, int gravity, int x, int y)
        popWin2.showAtLocation(findViewById(R.id.main_view), Gravity.CENTER, 0, 0);
    }
    private void showPopForMenu(){
        popWin3 = new PopWin3(this,onClickListener);
        popWin3.showAtLocation(findViewById(R.id.main_view),Gravity.RIGHT|Gravity.TOP,0,0);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
intent = new Intent(getBaseContext(),SucceedActivity.class);
            switch (v.getId()) {
                case R.id.qq:
                    System.out.println("qq");
                    startActivity(intent);
                    popWin2.dismiss();
                    finish();
                    break;
                case R.id.weixin:
                    System.out.println("weixin");
                    startActivity(intent);
                    popWin2.dismiss();
                    finish();
                    break;
                case R.id.weibo:
                    System.out.println("weibo");
                    startActivity(intent);
                    popWin2.dismiss();
                    finish();
                    break;
                case R.id.tv_01_pop:
                    popWin3.dismiss();
                    startActivity(new Intent(getBaseContext(),ForgetWordActivity.class));
                    break;
                case R.id.tv_02_pop:
                    popWin3.dismiss();
                    startActivity(new Intent(getBaseContext(),ChangeWordActivity.class));
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next:
                showPopFormBottom();
                break;
            case R.id.img_back_withdraw2_activity:
                finish();
                break;
            case R.id.img_menu_withdraw2_activity:
                showPopForMenu();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
