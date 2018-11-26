package com.zzg.tracing.app;

import android.app.Application;

/**
 * @author zzg
 * @time 2018/11/26--17:08
 * @Des
 */
public class BaseApplication extends Application {

    private static BaseApplication mContxt;
    @Override
    public void onCreate() {
        super.onCreate();
        mContxt = this;

    }


    public static BaseApplication getmContxt() {
        return mContxt;
    }
}
