package com.example.jiaofeng.meida.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.activity.JoinDetailsActivity;
import com.example.jiaofeng.meida.activity.MessageActivity;
import com.example.jiaofeng.meida.adapter.JoinRecyclerAdapter;
import com.example.jiaofeng.meida.refreshandupload.MyRecyclerView;
import com.example.jiaofeng.meida.refreshandupload.MyViewHolder;
import com.example.jiaofeng.meida.refreshandupload.OrdinaryPDLView;
import com.gyf.barlibrary.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaofeng on 2017/6/1.
 */

public class JoinFragment extends BaseFragment implements View.OnClickListener{
    private View view;
    private MyRecyclerView myRecyclerView;
    private JoinRecyclerAdapter joinRecyclerAdapter;
    private OrdinaryPDLView ordinaryPDLView;
    private int a = 0;
    private TextView tvNumber;
    private ImageView imgMessage;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_join,container,false);

        initview();
        ImmersionBar.with(getActivity()).statusBarDarkFont(true).init();

        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_join;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    private void initview(){
        tvNumber = (TextView) view.findViewById(R.id.tv_number_join_fragment);
        tvNumber.setText(""+getData().size());
        imgMessage = (ImageView) view.findViewById(R.id.img_meaasge_join_fragment);
        myRecyclerView = (MyRecyclerView) view.findViewById(R.id.recycler_join_fragment);
        ordinaryPDLView = (OrdinaryPDLView) view.findViewById(R.id.refreshupload_join_fragment);
        ordinaryPDLView.setMoveDistanceTop(ordinaryPDLView.MoveDistanceAll);

        imgMessage.setOnClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        joinRecyclerAdapter = new JoinRecyclerAdapter(getActivity(),getData());
        myRecyclerView.setAdapter(joinRecyclerAdapter);
        joinRecyclerAdapter.setOnItemClickListener(new MyViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), JoinDetailsActivity.class);
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
    public List<Integer> getData(){
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.gaoshangjin3x);
        list.add(R.mipmap.remen3x);
        list.add(R.mipmap.tuijian3x);
        return list;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(getActivity()).destroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_meaasge_join_fragment:
                Intent intent = new Intent(getActivity(), MessageActivity.class);

                startActivity(intent);

                break;
        }
    }
}
