package com.example.jiaofeng.meida.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.fragment.BaseFragment;
import com.example.jiaofeng.meida.fragment.FragmentFactory;

import java.util.ArrayList;

/**
 * Created by jiaofeng on 2017/6/1.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private Context context;
    public MyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = FragmentFactory.createFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
    /*@Override
    public CharSequence getPageTitle(int position) {

        return titleList.get(position);//标题
    }*/
    private int[] imageResId = {
            R.mipmap.informationed_tab3x,
            R.mipmap.joined_tab3x,
            R.mipmap.chated_tab3x,
            R.mipmap.myed_tab3x
    };




   /* @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        // return tabTitles[position];
        Drawable image = context.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }*/
}
