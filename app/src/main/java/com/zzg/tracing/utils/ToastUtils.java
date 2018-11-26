package com.zzg.tracing.utils;

import android.content.Context;
import android.widget.Toast;

import com.zzg.tracing.app.BaseApplication;


/**
 * @author zzg
 * @time 2018/5/17-17:45
 * @Des
 */
public class ToastUtils {
    private Context mContext;
    private Toast mToast;
    private static ToastUtils mToastUtils;

    private ToastUtils(Context context) {
        mToast = Toast.makeText(context.getApplicationContext(), null, Toast.LENGTH_SHORT);
    }

    public static synchronized ToastUtils getInstanc() {
        if (null == mToastUtils) {
            mToastUtils = new ToastUtils(BaseApplication.getmContxt());
        }
        return mToastUtils;
    }

    /**
     * 显示toast
     *
     * @param toastMsg
     */
    public void showToast(int toastMsg) {
        mToast.setText(toastMsg);
        mToast.show();
    }

    /**
     * 显示toast
     *
     * @param toastMsg
     */
    public void showToast(String toastMsg) {
        mToast.setText(toastMsg);
        mToast.show();
    }

    /**
     * 网络请求失败提示
     */
    public void showNetError() {
        mToast.setText("网络连接失败");
        mToast.show();
    }

    /**
     * 用户登录失败
     */
    public void showLoginError() {
        mToast.setText("用户登录失败");
        mToast.show();
    }

}