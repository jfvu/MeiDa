package com.example.jiaofeng.meida.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.adapter.ChatRecyclerAdapter;
import com.example.jiaofeng.meida.activity.ChatActivity;

import com.example.jiaofeng.meida.refreshandupload.MyRecyclerView;
import com.example.jiaofeng.meida.refreshandupload.MyViewHolder;
import com.example.jiaofeng.meida.refreshandupload.OrdinaryPDLView;
import com.gyf.barlibrary.ImmersionBar;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaofeng on 2017/6/1.
 */

public class ChatFragment extends BaseFragment {

    private View view;
    private MyRecyclerView myRecyclerView;
    private ChatRecyclerAdapter chatRecyclerAdapter;
    private OrdinaryPDLView ordinaryPDLView;
    private int a =0;
    //private TextView tvtitle;
    private CountDownTimer timer = new CountDownTimer(1000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            switch (a){
                case 1:
                    ordinaryPDLView.stopRefresh();
                    break;
                case 2:
                    ordinaryPDLView.stopLoadMore();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat,container,false);
        initview();
        return view;
    }
    private void initview(){
        ImmersionBar.with(getActivity()).statusBarDarkFont(true).init();
        myRecyclerView = (MyRecyclerView) view.findViewById(R.id.recycler_chat_fragment);
        ordinaryPDLView = (OrdinaryPDLView) view.findViewById(R.id.refreshupload_chat_fragment);
        ordinaryPDLView.setMoveDistanceTop(ordinaryPDLView.MoveDistanceAll);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        chatRecyclerAdapter = new ChatRecyclerAdapter(getActivity(),getData());
        myRecyclerView.setAdapter(chatRecyclerAdapter);
        chatRecyclerAdapter.setOnItemClickListener(new MyViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });
        ordinaryPDLView.setOnRefreshListener(new OrdinaryPDLView.onRefreshListener() {
            @Override
            public void onRefresh() {
                a = 1;
                timer.start();
            }

            @Override
            public void onLoadMore() {
                a = 2;
                timer.start();
            }
        });
    }
    public List<String> getData(){
        List<String> list = new ArrayList<>();
        for (int i = 0;i<20;i++){
            list.add("测试"+i);
        }
        return list;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(getActivity()).destroy();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chat;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {


    }


}
