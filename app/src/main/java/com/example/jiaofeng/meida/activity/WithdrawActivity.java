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
import com.example.jiaofeng.meida.adapter.Recycler2Adapter;
import com.example.jiaofeng.meida.adapter.WithDrawVpAdapter;
import com.example.jiaofeng.meida.entity.WithDraw;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class WithdrawActivity extends AutoLayoutActivity {
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
        setContentView(R.layout.activity_withdraw);
        initViews();
        initTabStr();
        initView();
    }

    private void initViews() {


        views.clear();
        inflater= LayoutInflater.from(this);
        View viewBankCard=inflater.inflate(R.layout.vp_bankcard,null);
        show(viewBankCard,1);//显示明细
        views.add(viewBankCard);
        View viewBankCard1=inflater.inflate(R.layout.vp_bankcard,null);
        show(viewBankCard1,2);//显示明细
        views.add(viewBankCard1);
        View viewBankCard2=inflater.inflate(R.layout.vp_bankcard,null);
        show(viewBankCard2,3);//显示明细
        views.add(viewBankCard2);
    }
    /*显示提现明细recyclerview*/
    private void show(View viewBankCard,int c) {
        RecyclerView recyclerView= (RecyclerView) viewBankCard.findViewById(R.id.recycler_view);
        List<WithDraw>list=new ArrayList<>();
        for(int i=0;i<3;i++){
            if(c==1){
                WithDraw w=new WithDraw("银行卡提现","2月21日",153666);
                list.add(w);
            }else if(c==2){
                WithDraw w=new WithDraw("微信提现","2月21日",153666);
                list.add(w);
            }else{
                WithDraw w=new WithDraw("支付宝提现","2月21日",153666);
                list.add(w);
            }

        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        Recycler2Adapter adapter=new Recycler2Adapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        imgBack = (ImageView) findViewById(R.id.img_back_withdrawactivity);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tab = ((TabLayout) findViewById(R.id.tab));
        vp = ((ViewPager) findViewById(R.id.vp));
        tab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < 3; i++) {
            tab.addTab(tab.newTab().setText(tablist.get(i)));
        }
        withDrawVpAdapter=new WithDrawVpAdapter(views, tablist);
        vp.setAdapter(withDrawVpAdapter);

//
        tab.setupWithViewPager(vp);
        tab.setTabsFromPagerAdapter(withDrawVpAdapter);
    }
    /**
     * 设置标题
     */
    private void initTabStr() {
        tablist.clear();
        tablist.add("银行卡");
        tablist.add("微信支付");
        tablist.add("支付宝");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
