package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by jiaofeng on 2017/6/2.
 */

public class Registeractivity extends AutoLayoutActivity implements View.OnClickListener{
    private Intent intent;
    private View view;
    private PopupWindow popupWindow;
    private WindowManager.LayoutParams layoutParams = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        view = getWindow().getDecorView();

        ImmersionBar.with(this).statusBarDarkFont(true).init();

        TextView tvBack = (TextView) findViewById(R.id.tv_back_register);
        Button butFinishRegister = (Button) findViewById(R.id.but_finish_register);
        Button butGetCode = (Button) findViewById(R.id.but_getcode_register);
        EditText etPhoneNumber = (EditText) findViewById(R.id.et_phonenumber_register);
        EditText etCode = (EditText) findViewById(R.id.et_getcode_register);
        EditText etPassword = (EditText) findViewById(R.id.et_password_register);
        TextView tvDeal = (TextView) findViewById(R.id.tv_deal_register);

        tvBack.setOnClickListener(this);
        tvDeal.setOnClickListener(this);
        butFinishRegister.setOnClickListener(this);


    }
/**显示popupwindow*/
    public void showPopupWindow(View view) {
        intent = new Intent(getApplicationContext(),CertificateActivity.class);
        //popup试图绑定
        View popupView = getLayoutInflater().inflate(R.layout.popupwindow_register, null);
        popupWindow = new PopupWindow(popupView);
        //医生认证
        popupView.findViewById(R.id.tv_doctor_popup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("register",1);
                startActivity(intent);
                popupWindow.dismiss();
                finish();
            }
        });
        //护士认证
        popupView.findViewById(R.id.tv_nurse_popup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("register",2);
                startActivity(intent);
                popupWindow.dismiss();
                finish();
            }
        });
        //其他认证
        popupView.findViewById(R.id.tv_other_popup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("register",3);
                startActivity(intent);
                popupWindow.dismiss();
                finish();
            }
        });
        //跳过
        popupView.findViewById(R.id.tv_jump_popup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();

            }
        });
        //设置PopupWindow的宽和高
        popupWindow.setWidth(700);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //popupWindow.setTouchable(false);
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);


        //设置背景变暗
        layoutParams = getWindow().getAttributes();
        layoutParams.alpha = 0.5f;
        getWindow().setAttributes(layoutParams);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                layoutParams.alpha = 1f;
                getWindow().setAttributes(layoutParams);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
        if (popupWindow!=null && popupWindow.isShowing()){
            popupWindow.dismiss();
            layoutParams.alpha = 0f;
            getWindow().setAttributes(layoutParams);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_back_register:
                Intent intent1 = new Intent(Registeractivity.this,LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.but_finish_register:
                showPopupWindow(view);
                break;
            case R.id.but_getcode_register:
                break;
            case R.id.tv_deal_register:
                Intent intent = new Intent(Registeractivity.this,ServiceDealActivity.class);
                startActivity(intent);
                break;
        }
    }
}
