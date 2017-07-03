package com.example.jiaofeng.meida.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;

import java.util.List;

/**
 * Created by jiaofeng on 2017/6/3.
 * 自定义popupwindow用来显示spiner下拉listview
 */

public class SpinerPopupWindow<T> extends PopupWindow {
    private LayoutInflater inflater;
    private ListView mListView;
    private List<T> list;
    private MyPopupWindowAdapter mAdapter;

    public SpinerPopupWindow(Context context, List<T> list, AdapterView.OnItemClickListener clickListener){
        super(context);
        inflater = LayoutInflater.from(context);
        this.list = list;
        init(clickListener);
    }
    public void init(AdapterView.OnItemClickListener clickListener){
        View view = inflater.inflate(R.layout.spiner_popupwindow,null);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        mListView = (ListView) view.findViewById(R.id.listview);
        mAdapter = new MyPopupWindowAdapter();
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(clickListener);
    }

    private class MyPopupWindowAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
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
            ViewHolder holder = null;
            if (convertView == null){
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.item_spiner,null);
                holder.tvName = (TextView) convertView.findViewById(R.id.tv_name_spiner_item);
                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvName.setText(getItem(position).toString());
            return convertView;
        }

        private class ViewHolder {
            private TextView tvName;
        }
    }
}
