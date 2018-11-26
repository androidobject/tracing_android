package com.zzg.tracing.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;


import com.zzg.tracing.app.BaseApplication;
import com.zzg.tracing.app.Constants;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author zzg
 * @time 2018/5/18-17:08
 * @Des
 */
public class SpUtil {

    //屏幕宽高
    public static final String SCREENWIDTH = "screenwidth";
    public static final String SCREENHEIGHT = "screenheight";
    //用户token
    public static final String USER_TOKEN = "token";



    /**
     * 保存boolean值串到sp中
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    /**
     * 获取sp中的boolean值
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }


    /**
     * 保存字符串到sp中
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
    }

    /**
     * 获取sp中的字符串
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static SharedPreferences getSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        return sp;
    }


    /**
     * 保存int值到sp中
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    /**
     * 获取保存的int类型的值
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static int getInt(Context context, String key) {
        return getInt(context, key, 0);
    }

    /**
     * 保存float类型的值到sp中
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putFloat(Context context, String key, float value) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putFloat(key, value);
        edit.commit();
    }

    /**
     * 获取保存的float类型的值
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static float getFloat(Context context, String key, float defValue) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_SAVE_FILE, Context.MODE_PRIVATE);
        return sp.getFloat(key, defValue);
    }

    public static float getFloat(Context context, String key) {
        return getFloat(context, key, 0f);
    }

    /**
     * writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
     * 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
     *
     * @param object 待加密的转换为String的对象
     * @return String   加密后的String
     */
    private static String Object2String(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            String string = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
            objectOutputStream.close();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用Base64解密String，返回Object对象
     *
     * @param objectString 待解密的String
     * @return object      解密后的object
     */
    private static Object String2Object(String objectString) {
        byte[] mobileBytes = Base64.decode(objectString.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mobileBytes);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void save(String key, Object saveObject) {
        String string = Object2String(saveObject);
        SpUtil.putString(BaseApplication.getmContxt(), key, string);
        if (key.equals("wechatCodeUrl")) {
            System.out.println("=====string====" + string);
        }
    }

    /**
     * 获取SharedPreference保存的对象
     *
     * @param key 储存对象的key
     * @return object 返回根据key得到的对象
     */
    public static Object get(String key) {
        String string = SpUtil.getString(BaseApplication.getmContxt(), key, null);
        if (string != null) {
            Object object = String2Object(string);
            return object;
        } else {
            return null;
        }
    }

//    /**
//     * \
//     * 保存用户信息
//     */
//    public static void saveUserInfo(LoginModel loginModel) {
//        Context context = BaseApplication.getmContxt();
//        //保存用户信息
//        SpUtil.putString(context, SpUtil.TOKEN, loginModel.getApi_token());
//        SpUtil.putString(context, SpUtil.USERNAME, loginModel.getUsername());
//        SpUtil.putString(context, SpUtil.ROLE_ID, loginModel.getRole_id() + "");
//
//    }
}
