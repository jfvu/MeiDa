package com.example.jiaofeng.meida.view;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.jiaofeng.meida.R;


/**
 * User: Picasso
 * Date: 2015-11-30
 * Time: 13:17
 * FIXME
 */
public class PicPopupWindow extends PopupWindow {

    private Button btn_user_album, btn_photograph, btn_cancel;
    private View mMenuView;
    private Activity mContext;

    public PicPopupWindow(Activity context, View.OnClickListener itemsOnClick) {
        super(context);
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.pic_popup, null);
        btn_user_album = (Button) mMenuView.findViewById(R.id.btn_user_album);
        btn_photograph = (Button) mMenuView.findViewById(R.id.btn_photograph);
        btn_cancel = (Button) mMenuView.findViewById(R.id.btn_cancel);
        // 设置按钮监听
        btn_user_album.setOnClickListener(itemsOnClick);
        btn_photograph.setOnClickListener(itemsOnClick);
        btn_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);

        this.setBackgroundDrawable(null);

        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.showAtLocation(
                mContext.findViewById(R.id.ll_certificateactivity),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);


        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }
}