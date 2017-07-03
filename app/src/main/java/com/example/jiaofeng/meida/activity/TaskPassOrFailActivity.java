package com.example.jiaofeng.meida.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class TaskPassOrFailActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView tvTitle;
    private ImageView imgLogo;
    private TextView tvLogo;
    private TextView tvContent;
    private Button butButton;
    private List<KeepData> list;
    private Random random;
    private int c;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskpassorfail);
        initview();
    }
    private void initview(){
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        imgBack = (ImageView) findViewById(R.id.img_back_taskpassorfail_activity);
        tvTitle = (TextView) findViewById(R.id.tv_title_taskpassorfail_activity);
        imgLogo = (ImageView) findViewById(R.id.img_tasklogo_taskpassorfail_activity);
        tvLogo = (TextView) findViewById(R.id.tv_tasklogo_taskpassorfail_activity);
        tvContent = (TextView) findViewById(R.id.tv_getmessage_taskpassorfail_activity);
        butButton = (Button) findViewById(R.id.but_finishorrewrite_taskpassorfail_activity);
        //tvContent.setTextColor(Color.parseColor());

        KeepData a =  new KeepData("任务通过",R.mipmap.finishtask3x,"恭喜，任务完成！","您将获得15个金币的奖励","完成",R.mipmap.submit3x,"#04A2E8");
        KeepData b =  new KeepData("任务失败",R.mipmap.fail3x,"遗憾，任务失败！","您需要重新填写本任务内容","重新填写",R.mipmap.rewirte3x,"#FF0000");
        list = new ArrayList<>();
        list.add(a);
        list.add(b);

        imgBack.setOnClickListener(this);
        butButton.setOnClickListener(this);
        random = new Random();
        c = random.nextInt(2);
        if (c == 1){
            tvTitle.setText(list.get(c).getTitle());
            imgLogo.setBackgroundResource(list.get(c).getLogo());
            tvLogo.setText(list.get(c).getBelowlogo());
            tvLogo.setTextColor(Color.parseColor(list.get(c).getColor()));
            tvContent.setText(list.get(c).getContent());
            butButton.setBackgroundResource(list.get(c).getButbg());
            butButton.setText(list.get(c).getBut());
            butButton.setTextColor(Color.parseColor(list.get(c).getColor()));

        }else if (c == 0){
            tvTitle.setText(list.get(c).getTitle());
            imgLogo.setBackgroundResource(list.get(c).getLogo());
            tvLogo.setText(list.get(c).getBelowlogo());
            tvLogo.setTextColor(Color.parseColor(list.get(c).getColor()));
            tvContent.setText(list.get(c).getContent());
            butButton.setBackgroundResource(list.get(c).getButbg());
            butButton.setText(list.get(c).getBut());
            butButton.setTextColor(Color.parseColor(list.get(c).getColor()));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_taskpassorfail_activity:
                finish();
                break;
            case R.id.but_finishorrewrite_taskpassorfail_activity:
if (c == 0){
    Intent intent = new Intent(TaskPassOrFailActivity.this, IncomeActivity.class);
    intent.putExtra("income",1);
    startActivity(intent);
    finish();
}else if (c == 1){
    finish();
}

                break;
        }
    }

    private class KeepData {
        private String title;
        private Integer logo;
        private String belowlogo;
        private String content;
        private String but;
        private Integer butbg;
        private String color;

        public KeepData(String title,Integer logo,String belowlogo,String content,String but,Integer butbg,String color){
            this.title = title;
            this.logo = logo;
            this.belowlogo = belowlogo;
            this.content = content;
            this.but = but;
            this.butbg = butbg;
            this.color = color;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getLogo() {
            return logo;
        }

        public void setLogo(Integer logo) {
            this.logo = logo;
        }

        public String getBelowlogo() {
            return belowlogo;
        }

        public void setBelowlogo(String belowlogo) {
            this.belowlogo = belowlogo;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getBut() {
            return but;
        }

        public void setBut(String but) {
            this.but = but;
        }

        public Integer getButbg() {
            return butbg;
        }

        public void setButbg(Integer butbg) {
            this.butbg = butbg;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

    }

}
