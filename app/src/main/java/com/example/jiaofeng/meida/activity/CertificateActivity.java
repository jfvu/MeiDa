package com.example.jiaofeng.meida.activity;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiaofeng.meida.R;
import com.example.jiaofeng.meida.Utils.OnPermissionRequestListener;
import com.example.jiaofeng.meida.Utils.PublicUtils;
import com.example.jiaofeng.meida.camera.FileUtil;
import com.example.jiaofeng.meida.view.PicPopupWindow;
import com.example.jiaofeng.meida.view.SpinerPopupWindow;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by jiaofeng on 2017/6/3.
 */

public class CertificateActivity extends AutoLayoutActivity implements View.OnClickListener{

    private TextView tv = null;
    private TextView tvTime;
    private ArrayList<String> listTest = new ArrayList();
    private TextView tvClass;
    private ImageView imgClass;
    private TextView tvLevel;
    private ImageView imgLevel;
    private TextView tvSubject;
    private ImageView imgSubject;
    private TextView tvPositionalNmae;
    private TextView tvPositionaltitle;
    private ImageView imgPositionaltitle;
    private TextView tvDuty;
    private ImageView imgDuty;
    private TextView tvLocation;
    private ImageView imgLocation;
    private Button butFinish;
    private RelativeLayout rlDuty;
    private RelativeLayout rlSpeciality;
    private SpinerPopupWindow<String> mSpinerPopupWindow;
    private PopupWindow.OnDismissListener dismissListener;
    private WindowManager.LayoutParams layoutParams = null;
    private PopupWindow popupWindow;
    private Intent intent;
    private View view;
    private Intent getFlag;
    private ImageView imgHead;
    private ImageView imgCard;
    private Uri imguri;
    private PicPopupWindow picPopupWindow;
    public static final int PERMISSION_CAMERA = 1;


    private static final int REQUESTCODE_PICK = 0;		// 相册选图标记
    private static final int REQUESTCODE_TAKE = 1;		// 相机拍照标记
    private static final int REQUESTCODE_CUTTING = 2;	// 图片裁切标记
    private String urlpath;			// 图片本地路径
    private static final String IMAGE_FILE_NAME = "avatarImage.jpg";// 头像文件名称
    private Bitmap cutImageBitmap;
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);

        layoutParams = getWindow().getAttributes();
        view = getWindow().getDecorView();

        ImmersionBar.with(this).statusBarDarkFont(true).init();

        getFlag = getIntent();
        int flag = getFlag.getIntExtra("register",1);

        mContext = CertificateActivity.this;

        tvTime = (TextView) findViewById(R.id.tv_time_certificate);
        ImageView imgTime = (ImageView) findViewById(R.id.img_time_certificate);
        imgClass = (ImageView) findViewById(R.id.img_class_certificate);
        tvClass = (TextView) findViewById(R.id.tv_class_certificate);
        tvLevel = (TextView) findViewById(R.id.tv_level_certificate);
        imgLevel = (ImageView) findViewById(R.id.img_level_certificate);
        tvSubject = (TextView) findViewById(R.id.tv_subject_certificate);
        imgSubject = (ImageView) findViewById(R.id.img_subject_certificate);
        tvPositionalNmae = (TextView) findViewById(R.id.tv_positionaltitle);
        tvPositionaltitle = (TextView) findViewById(R.id.tv_positionaltitle_certificate);
        imgPositionaltitle = (ImageView) findViewById(R.id.img_positionaltitle_certificate);
        tvDuty = (TextView) findViewById(R.id.tv_duty_certificate);
        imgDuty = (ImageView) findViewById(R.id.img_duty_certificate);
        tvLocation = (TextView) findViewById(R.id.tv_location_certificate);
        imgLocation = (ImageView) findViewById(R.id.img_location_cartificate);
        butFinish = (Button) findViewById(R.id.but_finish_certificate);
        rlDuty = (RelativeLayout) findViewById(R.id.rl_duty_certificate);
        rlSpeciality = (RelativeLayout) findViewById(R.id.rl_specialty_certificate);
        imgHead = (ImageView) findViewById(R.id.img_head_certificate);
        imgCard = (ImageView) findViewById(R.id.img_card_certificate);

        imgTime.setOnClickListener(this);
        imgClass.setOnClickListener(this);
        imgLevel.setOnClickListener(this);
        imgSubject.setOnClickListener(this);
        imgPositionaltitle.setOnClickListener(this);
        imgDuty.setOnClickListener(this);
        imgLocation.setOnClickListener(this);
        butFinish.setOnClickListener(this);
        imgHead.setOnClickListener(this);
        imgCard.setOnClickListener(this);

        mSpinerPopupWindow = new SpinerPopupWindow<>(CertificateActivity.this,listTest,itemClickListener);

        if (flag == 2){
            rlDuty.setVisibility(View.GONE);
            rlSpeciality.setVisibility(View.GONE);
            tvPositionalNmae.setText("护士职称");
        }
        else  if (flag == 3){}

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
        if (cutImageBitmap != null && cutImageBitmap.isRecycled()){
            cutImageBitmap.recycle();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_time_certificate:
                //弹出系统时间dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(CertificateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvTime.setText(String.format("%d-%d-%d",year,month+1,dayOfMonth));
                    }
                }, 2017,1,1);
                datePickerDialog.show();
                break;
            case R.id.img_class_certificate:
                tv = tvClass;
                showSpinerPopupWindow(imgClass);
                break;
            case R.id.img_level_certificate:
                tv = tvLevel;
                showSpinerPopupWindow(imgLevel);
                break;
            case R.id.img_subject_certificate:
                tv = tvSubject;
                showSpinerPopupWindow(imgSubject);
                break;
            case R.id.img_positionaltitle_certificate:
                tv = tvPositionaltitle;
                showSpinerPopupWindow(imgPositionaltitle);
                break;
            case R.id.img_duty_certificate:
                tv = tvDuty;
                showSpinerPopupWindow(imgDuty);
                break;
            case R.id.img_location_cartificate:
                tv = tvLocation;
                showSpinerPopupWindow(imgLocation);
                break;
            case R.id.but_finish_certificate:
                showPopupWindow(view);
                break;
            case R.id.img_head_certificate:

                picPopupWindow = new PicPopupWindow(CertificateActivity.this,picPopupItemsOnClick);
                break;
            case R.id.img_card_certificate:
                picPopupWindow = new PicPopupWindow(CertificateActivity.this,picPopupItemsOnClick);
                break;
        }
    }

    private void showSpinerPopupWindow(ImageView img ) {
        mSpinerPopupWindow.setWidth(img.getWidth()+tvClass.getWidth());
        mSpinerPopupWindow.showAsDropDown(img,0,30);
        final WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.alpha = 0.5f;
        getWindow().setAttributes(layoutParams);
        //setSpinerImg(R.mipmap.pullup3x);
        initPopupWindow();
        mSpinerPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                layoutParams.alpha = 1f;
                getWindow().setAttributes(layoutParams);
            }
        });
    }



    /**
     * popupwindow显示的ListView的item点击事件
     */
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            mSpinerPopupWindow.dismiss();
            tv.setText(listTest.get(position));
            Toast.makeText(CertificateActivity.this, "点击了:" + listTest.get(position),Toast.LENGTH_LONG).show();
        }
    };
    /**
     * pop初始化
     */
    public void initPopupWindow() {
        /**
         * 监听popupwindow取消,更改图标
         */
        dismissListener = new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //setSpinerImg(R.mipmap.pulldown3x);
            }
        };
        mSpinerPopupWindow.setOnDismissListener(dismissListener);
        if (listTest.size()==0){
            for (int i = 0 ; i<5; i++){
                listTest.add("测试"+i);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mSpinerPopupWindow != null && mSpinerPopupWindow.isShowing()){
            mSpinerPopupWindow.dismiss();
            mSpinerPopupWindow = null;

            layoutParams.alpha = 1f;
            getWindow().setAttributes(layoutParams);
        }
        return super.onTouchEvent(event);

    }
    /**显示popupwindow*/
    public void showPopupWindow(View view) {
        intent = new Intent(getApplicationContext(),LoginActivity.class);
        //popup试图绑定
        View popupView = getLayoutInflater().inflate(R.layout.popupwindow_hint, null);
        popupWindow = new PopupWindow(popupView);
        //取消
        popupView.findViewById(R.id.tv_cencal_hint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("certificate",1);
                startActivity(intent);
                popupWindow.dismiss();
                finish();
            }
        });
        //确认
        popupView.findViewById(R.id.tv_finish_hint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("certificate",2);
                startActivity(intent);
                popupWindow.dismiss();
                finish();
            }
        });

        //设置PopupWindow的宽和高
        popupWindow.setWidth(700);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //popupWindow.setTouchable(false);
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);


        //设置背景变暗
        layoutParams = getWindow().getAttributes();
        layoutParams.alpha = 0.5f;
        getWindow().setAttributes(layoutParams);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                layoutParams.alpha = 1f;
                getWindow().setAttributes(layoutParams);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUESTCODE_PICK:// 直接从相册获取
                /*try {
                    startPhotoZoom(data.getData());
                } catch (NullPointerException e) {
                    e.printStackTrace();// 用户点击取消操作
                }*/
                break;
            case REQUESTCODE_TAKE:// 调用相机拍照
                /*File temp = new File(Environment.getExternalStorageDirectory() + "/" + IMAGE_FILE_NAME);
                startPhotoZoom(Uri.fromFile(temp));*/
                break;
            case REQUESTCODE_CUTTING:// 取得裁剪后的图片
                /*if (data != null) {
                    setPicToView(data);
                }*/
                break;
        }
    }


    private View.OnClickListener picPopupItemsOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_user_album:


                    /*Intent pickIntent = new Intent(Intent.ACTION_PICK, null);

                    pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image*//*");
                    startActivityForResult(pickIntent, REQUESTCODE_PICK);*/
                    break;
                case R.id.btn_photograph:
                    /*PublicUtils.getCameraPermission(CertificateActivity.this, PERMISSION_CAMERA, new OnPermissionRequestListener() {
                        @Override
                        public void onSuccess() {

                            Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                                takeIntent.setFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                                //Uri uri = FileProvider.getUriForFile(mContext,"com.example.jiaofeng.meida.fileprovider",new File(Environment.getExternalStorageDirectory() + "/" + IMAGE_FILE_NAME));
                            }
                            else{
                            //下面这句指定调用相机拍照后的照片存储的路径
                            takeIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                    Uri.fromFile(new File(Environment.getExternalStorageDirectory(), IMAGE_FILE_NAME)));}
                            startActivityForResult(takeIntent, REQUESTCODE_TAKE);
                        }
                    });*/


                    break;
            }

            if (picPopupWindow != null) {
                picPopupWindow.dismiss();
            }
        }
    };

    /**
     * 裁剪图片方法实现
     * @param uri
     */
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, REQUESTCODE_CUTTING);
    }
    /**
     * 保存裁剪之后的图片数据
     * @param picdata
     */
    private void setPicToView(Intent picdata) {
        Bundle extras = picdata.getExtras();
        if (extras != null) {
            // 取得SDCard图片路径做显示
            Bitmap photo = extras.getParcelable("data");
            Drawable drawable = new BitmapDrawable(null, photo);
            urlpath = FileUtil.saveFile(mContext, "temphead.jpg", photo);
            imgHead.setImageDrawable(drawable);


        }
    }

}
