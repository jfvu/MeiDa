package com.example.jiaofeng.meida.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.adapter.ListviewAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaofeng on 2017/6/3.
 */

public class InformationDetailsActivity extends AutoLayoutActivity implements View.OnClickListener{
    private EditText etMessage;
    private ListView listView;
    private List<String> list;
    private ImageView imgBack;
    /*private int a = 0;
    String b = "1234";*/

    public InformationDetailsActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationdetails);

        initview();

        /*etMessage.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    a=b.length();
                    etMessage.setSelection(a);
                }
            }
        });*/
    }
    private void initview(){

        list = new ArrayList<>();
        list.add("昵称1");
        list.add("昵称2");

        ImmersionBar.with(this).statusBarDarkFont(true).init();
        etMessage = (EditText) findViewById(R.id.et_massage_informationdetails);
        listView = (ListView) findViewById(R.id.lv_informationdetails);
        listView.setAdapter(new ListviewAdapter(list,InformationDetailsActivity.this));
        imgBack = (ImageView) findViewById(R.id.img_back_informationdetails);
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
            case R.id.img_back_informationdetails:
                finish();
                break;
        }
    }
}
