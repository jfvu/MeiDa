package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.adapter.MyFragmentAdapter;
import com.zhy.autolayout.AutoLayoutActivity;

import java.lang.reflect.Field;

/**
 * Created by jiaofeng on 2017/6/1.
 */

public class MainActivity extends AutoLayoutActivity {

    private TabLayout tab;
    private ViewPager vp;
    private int number;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp_main);
        tab = (TabLayout) findViewById(R.id.tab_main);
        MyFragmentAdapter fragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),getApplication());
        vp.setAdapter(fragmentAdapter);

        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("资讯");
        tab.getTabAt(1).setText("参与");
        tab.getTabAt(2).setText("聊天");
        tab.getTabAt(3).setText("我的");
        tab.getTabAt(0).setIcon(R.drawable.selector_information);
        tab.getTabAt(1).setIcon(R.drawable.selsector_join);
        tab.getTabAt(2).setIcon(R.drawable.selector_chat);
        tab.getTabAt(3).setIcon(R.drawable.selector_my);

        getVpItem();


    }
/**显示哪个viewpager*/
    private void getVpItem() {
        Intent intent = getIntent();
        if (intent!= null){
            number = intent.getIntExtra("homeactivity",0);
        }

        try {
            Field field = vp.getClass().getField("mCurItem");
            field.setAccessible(true);
            field.setInt(vp,number);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        vp.setCurrentItem(number);
    }

}
