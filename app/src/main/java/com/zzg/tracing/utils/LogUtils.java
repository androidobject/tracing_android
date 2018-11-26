package com.zzg.tracing.utils;

import android.util.Log;

/**
 * log created  by zzg  2018-4-21
 */

public class LogUtils {


    public static final String tag = "zzg";


    public static void d(String s) {
        Log.d(tag, s);
    }

    public static void d(String newtag, String s) {
        Log.d(newtag, s);
    }

    public static void e(String e) {
        Log.d(tag, e);
    }

    public static void e(String newtag, String e) {
        Log.d(newtag, e);
    }

}
