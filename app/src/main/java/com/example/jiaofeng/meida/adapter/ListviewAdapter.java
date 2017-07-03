package com.example.jiaofeng.meida.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;

import java.util.List;

/**
 * Created by jiaofeng on 2017/6/4.
 */


public class ListviewAdapter extends BaseAdapter {

    private List<String> list;
    private LayoutInflater inflater;

    public ListviewAdapter(List<String> list, Context context){
        this.list = list;
        this.inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_listview_informationdetails,null);
        TextView tvNumber = (TextView) view.findViewById(R.id.tv_number_informationdetails);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name_informationdetails);
        tvNumber.setText(position+1+"楼");
        tvName.setText(list.get(position));
        return view;
    }
}
