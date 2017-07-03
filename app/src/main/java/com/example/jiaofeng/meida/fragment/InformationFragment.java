package com.example.jiaofeng.meida.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.activity.InformationDetailsActivity;
import com.example.jiaofeng.meida.refreshandupload.MyRecyclerView;
import com.example.jiaofeng.meida.refreshandupload.MyViewHolder;
import com.example.jiaofeng.meida.refreshandupload.OrdinaryPDLView;
import com.example.jiaofeng.meida.adapter.RecyclerAdapter;
import com.gyf.barlibrary.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaofeng on 2017/6/1.
 */

public class InformationFragment extends BaseFragment {
    private View view;
    private MyRecyclerView myRecyclerView;
    private RecyclerAdapter recyclerAdapter;
    private OrdinaryPDLView ordinaryPDLView;
    private int a = 0;
    private TextView tvNumber;
    private CountDownTimer timer = new CountDownTimer(3000,1000) {
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_information,container,false);

        initview();

        ImmersionBar.with(getActivity()).statusBarDarkFont(true).init();

        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_information;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    private void initview(){
        tvNumber = (TextView) view.findViewById(R.id.tv_number_information_fragment);
        tvNumber.setText(""+getData().size());
        myRecyclerView = (MyRecyclerView) view.findViewById(R.id.recycler_information_fragment);
        ordinaryPDLView = (OrdinaryPDLView) view.findViewById(R.id.refreshupload_information_fragment);
        ordinaryPDLView.setMoveDistanceTop(ordinaryPDLView.MoveDistanceAll);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter = new RecyclerAdapter(getActivity(),getData());
        myRecyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnItemClickListener(new MyViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), InformationDetailsActivity.class);
                startActivity(intent);
            }
        });
        ordinaryPDLView.setOnRefreshListener(new OrdinaryPDLView.onRefreshListener() {
            @Override
            public void onRefresh() {
                a = 1;
                timer.start();
                tvNumber.setText(""+getData().size());
            }

            @Override
            public void onLoadMore() {
                a = 2;
                timer.start();
                tvNumber.setText(""+getData().size());
            }
        });
    }
    public List<String> getData(){
        List<String> list = new ArrayList<>();
        for (int i = 1;i<=20;i++){
            list.add("标题"+i);
        }
        return list;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(getActivity()).destroy();
    }
}
