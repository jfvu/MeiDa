package com.example.jiaofeng.meida.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.entity.Work;

import java.util.List;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class WorkRecyclerAdapter extends RecyclerView.Adapter {
    private List<Work> models;
    private Context context;
    public WorkRecyclerAdapter(List<Work> models,Context context){
        this.models = models;
        this.context=context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,content,date,name;
        private ImageView header;
        private TextView price,peoplenumber,looknumber;
        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.tv_id_recyclerjoin_item);
            header= (ImageView) itemView.findViewById(R.id.img_head_recyclerjoin_item);
            title = (TextView) itemView.findViewById(R.id.tv_title_recyclejoin_item);
            content = (TextView) itemView.findViewById(R.id.tv_content_recyclerjoin_item);
            date = (TextView) itemView.findViewById(R.id.tv_time_recyclerjoin_item);
            price= (TextView) itemView.findViewById(R.id.tv_money_recyclerjoin_item);
            peoplenumber= (TextView) itemView.findViewById(R.id.tv_peoplenumber_recyclerjoin_item);
            looknumber= (TextView) itemView.findViewById(R.id.tv_looknumber_recyclerjoin_item);
        }
        public TextView getTitle() {
            return title;
        }
        public TextView getDate() {
            return date;
        }

        public TextView getContent() {
            return content;
        }

        public TextView getName() {
            return name;
        }

        public ImageView getHeader() {
            return header;
        }

        public TextView getPrice() {
            return price;
        }

        public TextView getPeoplenumber() {
            return peoplenumber;
        }

        public TextView getLooknumber() {
            return looknumber;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WorkRecyclerAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_join,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final WorkRecyclerAdapter.ViewHolder vh = (WorkRecyclerAdapter.ViewHolder) holder;
        vh.getHeader().setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.touxiang3x));
        vh.getContent().setText(models.get(position).getContent());
        vh.getLooknumber().setText(models.get(position).getLooknumber()+"");
        vh.getPeoplenumber().setText(models.get(position).getPeoplenumber()+"");
        vh.getName().setText(models.get(position).getName());
        vh.getPrice().setText(models.get(position).getPrice()+"");
        vh.getTitle().setText(models.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
