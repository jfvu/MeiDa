package com.example.jiaofeng.meida.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.meida.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

public class HomeActivity extends AutoLayoutActivity implements View.OnClickListener{
private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intent = new Intent(HomeActivity.this,MainActivity.class);

        ImmersionBar.with(this).statusBarDarkFont(true).init();
        //设置系统栏为透明

        ImageView imgNotification = (ImageView) findViewById(R.id.img_notification_main);
        ImageView imgMy = (ImageView) findViewById(R.id.img_my_main);
        ImageView imgChat = (ImageView) findViewById(R.id.img_chat_main);
        ImageView imgInformation = (ImageView) findViewById(R.id.img_information_main);
        ImageView imgJoin = (ImageView) findViewById(R.id.img_join_main);

        TextView tvChat = (TextView) findViewById(R.id.tv_chat_main);
        TextView tvInformation = (TextView) findViewById(R.id.tv_information_main);
        TextView tvJoin = (TextView) findViewById(R.id.tv_join_main);

        imgNotification.setOnClickListener(this);
        imgMy.setOnClickListener(this);
        imgChat.setOnClickListener(this);
        imgInformation.setOnClickListener(this);
        imgJoin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_notification_main:
                Intent intent1 = new Intent(HomeActivity.this,MessageActivity.class);
                intent1.putExtra("messageactivity",1);
                startActivity(intent1);
                finish();
                break;
            case R.id.img_my_main:
                intent.putExtra("homeactivity",3);
                startActivity(intent);
                finish();
                break;
            case R.id.img_chat_main:
                intent.putExtra("homeactivity",2);
                startActivity(intent);
                finish();
                break;
            case R.id.img_information_main:
                intent.putExtra("homeactivity",0);
                startActivity(intent);
                finish();
                break;
            case R.id.img_join_main:
                intent.putExtra("homeactivity",1);
                startActivity(intent);
                finish();
                break;
        }
    }

    //图片模糊调用方法：
   /* ImageView ivPhoto = (ImageView) findViewById(R.id.iv_photo);
    BitmapDrawable bitmapDrawable =
            (BitmapDrawable) ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher);
    ivPhoto.setImageDrawable(new BitmapDrawable(getResources(),
        BlurBuilder.blur(getApplicationContext(), bitmapDrawable.getBitmap())));*/
    /**模糊图片*/
   public class BlurBuilder {
        private static final float BLUR_RADIUS = 7.5F;
        public  Bitmap blur(Context context, Bitmap inputBitmap){
            Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);
            RenderScript renderScript = RenderScript.create(context);
            ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            Allocation tmpIn = Allocation.createFromBitmap(renderScript,inputBitmap);
            Allocation tmpOut = Allocation.createFromBitmap(renderScript,outputBitmap);
            scriptIntrinsicBlur.setRadius(BLUR_RADIUS);
            scriptIntrinsicBlur.setInput(tmpIn);
            scriptIntrinsicBlur.forEach(tmpOut);
            tmpOut.copyTo(outputBitmap);
            return outputBitmap;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
