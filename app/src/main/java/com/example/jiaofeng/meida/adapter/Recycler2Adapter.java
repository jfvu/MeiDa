package com.example.jiaofeng.meida.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.entity.WithDraw;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */

public class Recycler2Adapter extends RecyclerView.Adapter {

    private List<WithDraw> models;

    public Recycler2Adapter(List<WithDraw> models){
        this.models = models;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,number,date;

        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            number = (TextView) itemView.findViewById(R.id.number);
            date = (TextView) itemView.findViewById(R.id.date);
        }

        public TextView getNumber(){
            return number;
        }

        public TextView getTitle(){
            return title;
        }

        public TextView getDate(){
            return date;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bankcard,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final ViewHolder vh = (ViewHolder) holder;
        vh.getDate().setText(models.get(position).getDate());
        vh.getTitle().setText(models.get(position).getTitle());
        vh.getNumber().setText(models.get(position).getNumber()+"");
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
