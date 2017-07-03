package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.adapter.MessageRecyclerAdapter;
import com.example.jiaofeng.meida.refreshandupload.MyRecyclerView;
import com.example.jiaofeng.meida.refreshandupload.MyViewHolder;
import com.example.jiaofeng.meida.refreshandupload.OrdinaryPDLView;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class MessageActivity extends AutoLayoutActivity implements View.OnClickListener{
    private View view;
    private MyRecyclerView myRecyclerView;
    private MessageRecyclerAdapter messageRecyclerAdapter;
    private OrdinaryPDLView ordinaryPDLView;
    private int a = 0;
    private TextView tvReadAll;
    private ImageView imgBack;
    private Intent intent;
    private int tag;
    private CountDownTimer timer = new CountDownTimer(1000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            /*switch (a){
                case 1:
                    ordinaryPDLView.stopRefresh();
                    break;
                case 2:
                    ordinaryPDLView.stopLoadMore();
            }*/

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        initview();
    }
    private void initview(){
        intent = getIntent();
        tag = intent.getIntExtra("messageactivity",0);

        ImmersionBar.with(this).statusBarDarkFont(true).init();
        tvReadAll = (TextView) findViewById(R.id.img_readed_message_activity);
        tvReadAll.setOnClickListener(this);
        imgBack = (ImageView) findViewById(R.id.img_back_message_activity);
        imgBack.setOnClickListener(this);
        myRecyclerView = (MyRecyclerView) findViewById(R.id.recycler_message_activity);
        ordinaryPDLView = (OrdinaryPDLView) findViewById(R.id.refreshupload_message_activity);
        ordinaryPDLView.setMoveDistanceTop(ordinaryPDLView.MoveDistanceAll);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MessageActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        messageRecyclerAdapter = new MessageRecyclerAdapter(MessageActivity.this,getData());
        myRecyclerView.setAdapter(messageRecyclerAdapter);
        messageRecyclerAdapter.setOnItemClickListener(new MyViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(MessageActivity.this,MessageDetailsActivity.class);
                startActivity(intent);
            }
        });
        ordinaryPDLView.setOnRefreshListener(new OrdinaryPDLView.onRefreshListener() {
            @Override
            public void onRefresh() {
                /*a = 1;
                timer.start();*/
            }

            @Override
            public void onLoadMore() {
               /* a = 2;
                timer.start();*/
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_readed_message_activity:
                break;
            case R.id.img_back_message_activity:
                if (tag == 1){
                    intent = new Intent(MessageActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else if (tag == 0){
                    /*intent = new Intent(MessageActivity.this,MainActivity.class);
                    //intent.putExtra("homeactivity",1);
                    startActivity(intent);*/
                    finish();
                }
                else if (tag == 3){}
                break;
        }
    }
    public List<Integer> getData(){
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.noread3x);
        list.add(R.mipmap.readed3x);
        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
