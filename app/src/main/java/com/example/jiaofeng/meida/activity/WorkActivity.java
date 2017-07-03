package com.example.jiaofeng.meida.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.adapter.WithDrawVpAdapter;
import com.example.jiaofeng.meida.adapter.WorkRecyclerAdapter;
import com.example.jiaofeng.meida.entity.Work;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class WorkActivity extends AutoLayoutActivity {

    private ViewPager vp;
    private TabLayout tab;
    private List<String> tablist = new ArrayList<>();
    private List<View> views = new ArrayList<>();
    private WithDrawVpAdapter withDrawVpAdapter;
    private LayoutInflater inflater;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        initViews();
        initTabStr();
        initView();
    }

    private void initViews() {
        views.clear();
        inflater = LayoutInflater.from(this);
        View viewBankCard = inflater.inflate(R.layout.vp_work, null);
        show(viewBankCard, 1);//显示明细
        views.add(viewBankCard);
        View viewBankCard1 = inflater.inflate(R.layout.vp_work, null);
        show(viewBankCard1, 2);//显示明细
        views.add(viewBankCard1);
    }

    /*显示提现明细recyclerview*/
    private void show(View viewBankCard, int c) {
        RecyclerView recyclerView = (RecyclerView) viewBankCard.findViewById(R.id.recycler_view);
        List<Work> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (c == 1) {
                Work w = new Work("头像", "这是标题啊", "这是内容","小王",32,"2min32s",321,425);
                list.add(w);
            } else  {
                Work w = new Work("头像", "这是标题啊", "这是内容","小王",32,"2min32s",321,425);
                list.add(w);
            }

        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        WorkRecyclerAdapter adapter = new WorkRecyclerAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        imgBack = (ImageView) findViewById(R.id.img_back_workactivity);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        tab = ((TabLayout) findViewById(R.id.tab));
        vp = ((ViewPager) findViewById(R.id.vp));
        tab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < 2; i++) {
            tab.addTab(tab.newTab().setText(tablist.get(i)));
        }
        withDrawVpAdapter = new WithDrawVpAdapter(views, tablist);
        vp.setAdapter(withDrawVpAdapter);

//        将tablelayout和ViewPager关联起来
        tab.setupWithViewPager(vp);
        tab.setTabsFromPagerAdapter(withDrawVpAdapter);
    }

    /**
     * 设置标题
     */
    private void initTabStr() {
        tablist.clear();
        tablist.add("已完成");
        tablist.add("未完成");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
