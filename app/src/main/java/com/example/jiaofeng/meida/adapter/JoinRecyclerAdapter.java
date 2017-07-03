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

public class JoinRecyclerAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Integer> stringList;
    private MyViewHolder.OnItemClickListener mOnItemClickListener;
    private MyViewHolder.OnItemLongClickListener mOnItemLongClickListener;

    public JoinRecyclerAdapter(Context context,List<Integer> stringList){
        this.mContext = context;
        this.stringList = stringList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler_join,parent,false);
        return new ViewHolder(view,mOnItemClickListener,mOnItemLongClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        //viewHolder.textview.setText(stringList.get(position));
        //viewHolder.imgTag.setImageDrawable(stringList.get(position));
        viewHolder.imgTag.setImageResource(stringList.get(position));

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
    private class ViewHolder extends MyViewHolder {
        private TextView textview;
        private ImageView imgTag;

        public ViewHolder(View itemView, MyViewHolder.OnItemClickListener listener1, MyViewHolder.OnItemLongClickListener listener2) {
            super(itemView, listener1, listener2);
            AutoUtils.autoSize(itemView);
            //textview = (TextView) itemView.findViewById();
            imgTag = (ImageView) itemView.findViewById(R.id.img_tag_recyclerjoin_item);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
    }
    public void setOnItemClickListener(MyViewHolder.OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public void setOnItemLongClickListener(MyViewHolder.OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
    }
}
