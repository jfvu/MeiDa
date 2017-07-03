package com.example.jiaofeng.meida.fragment;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import java.util.HashMap;

/**
 * Created by jiaofeng on 2017/6/1.
 */

public class FragmentFactory {
    private static HashMap<Integer, BaseFragment> mFragmentHashMap = new HashMap<>();

    public static BaseFragment createFragment(int pos) {

        BaseFragment baseFragment = mFragmentHashMap.get(pos);//从集合中取出Fragment
        if (baseFragment == null) {
            switch (pos) {
                case 0:
                    baseFragment = new InformationFragment();
                    break;
                case 1:
                    baseFragment = new JoinFragment();
                    break;
                case 2:
                    baseFragment = new ChatFragment();
                    break;
                case 3:
                    baseFragment = new MyFragment();
                    break;
                default:
                    break;
            }
            mFragmentHashMap.put(pos, baseFragment);//存入集合中
        }
        return baseFragment;
    }

}
