package com.example.jiaofeng.meida.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.refreshandupload.MyViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class MessageRecyclerAdapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Integer> list;
    private MyViewHolder.OnItemClickListener onItemClickListener;
    private MyViewHolder.OnItemLongClickListener onItemLongClickListener;

    public MessageRecyclerAdapter(Context context,List<Integer> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler_messageactivity,parent,false);
        return new ViewHolder(view,onItemClickListener,onItemLongClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.imgRead.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private class ViewHolder extends MyViewHolder {
        private TextView textview;
        private ImageView imgRead;

        public ViewHolder(View itemView, MyViewHolder.OnItemClickListener listener1, MyViewHolder.OnItemLongClickListener listener2) {
            super(itemView, listener1, listener2);
            //textview = (TextView) itemView.findViewById();
            AutoUtils.autoSize(itemView);
            imgRead = (ImageView) itemView.findViewById(R.id.img_read_recyclermessage_item);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
    }
    public void setOnItemClickListener(MyViewHolder.OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public void setOnItemLongClickListener(MyViewHolder.OnItemLongClickListener listener) {
        onItemLongClickListener = listener;
    }
}
