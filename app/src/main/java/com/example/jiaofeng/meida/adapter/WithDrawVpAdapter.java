package com.example.jiaofeng.meida.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class WithDrawVpAdapter extends PagerAdapter {
    //    这个是viewpager的填充视图
    private List<View> views;
    //    这个是table导航条里面的内容填充
    private List<String> tabstrs;

    public WithDrawVpAdapter(List<View> views, List<String> tabstrs) {
        this.views = views;
        this.tabstrs = tabstrs;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    //    这个是和tablelayout相关的
    @Override
    public CharSequence getPageTitle(int position) {
        return tabstrs.get(position);
    }
}
