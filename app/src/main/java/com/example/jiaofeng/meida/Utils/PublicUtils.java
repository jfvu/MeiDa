package com.example.jiaofeng.meida.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by jiaofeng on 17/5/15.
 */

public class PublicUtils {

    public static void getCameraPermission(Activity activity,int requestCode,OnPermissionRequestListener onPermissionRequestListener){
        /**
         * 下于23不需要权限
         */
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            /**
             * 判断是否有权限
             */
            if (activity.checkSelfPermission(Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED
                    ||activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                activity.requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},requestCode);
            }
            else {
                onPermissionRequestListener.onSuccess();
            }
        }
        else {
            onPermissionRequestListener.onSuccess();

        }
    }

    /**
     * 相册
     * @param activity
     * @param requestCode
     * @param onPermissionRequestListener
     */
    public static void getCameraPermissionAlbum(Activity activity,int requestCode,OnPermissionRequestListener onPermissionRequestListener){
        /**
         * 下于23不需要权限
         */
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            /**
             * 判断是否有权限
             */
            if (activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                activity.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},requestCode);
            }
            else {
                onPermissionRequestListener.onSuccess();
            }
        }
        else {
            onPermissionRequestListener.onSuccess();

        }
    }
}
