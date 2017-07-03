package com.example.jiaofeng.meida.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.activity.IncomeActivity;
import com.example.jiaofeng.meida.activity.SetActivity;
import com.example.jiaofeng.meida.activity.ShareActivity;
import com.example.jiaofeng.meida.activity.WithdrawActivity;
import com.example.jiaofeng.meida.activity.WorkActivity;

/**
 * Created by jiaofeng on 2017/6/1.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout rel_set,rel_work,rel_share;
    private LinearLayout lin_withdraw,lin_income;
    @Override
    protected int getLayoutId() {
        return R.layout.frament_mine;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rel_set= (RelativeLayout) view.findViewById(R.id.rel_set);
        rel_set.setOnClickListener(this);
        rel_work= (RelativeLayout) view.findViewById(R.id.rel_work);
        rel_work.setOnClickListener(this);
        lin_withdraw= (LinearLayout) view.findViewById(R.id.lin_withdraw);
        lin_withdraw.setOnClickListener(this);
        rel_share= (RelativeLayout) view.findViewById(R.id.rel_share);
        rel_share.setOnClickListener(this);
        lin_income= (LinearLayout) view.findViewById(R.id.lin_income);
        lin_income.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rel_set:
                startActivity(new Intent(getActivity(), SetActivity.class));
                break;
            case R.id.lin_withdraw:
                startActivity(new Intent(getActivity(), WithdrawActivity.class));
                break;
            case R.id.rel_work:
                startActivity(new Intent(getActivity(), WorkActivity.class));
                break;
            case R.id.rel_share:
                startActivity(new Intent(getActivity(), ShareActivity.class));
                break;
            case R.id.lin_income:
                startActivity(new Intent(getActivity(), IncomeActivity.class));
                break;
        }
    }
}
