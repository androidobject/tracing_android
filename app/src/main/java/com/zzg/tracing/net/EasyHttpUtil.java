package com.zzg.tracing.net;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.request.PostRequest;
import com.zzg.tracing.app.BaseApplication;
import com.zzg.tracing.utils.LogUtils;
import com.zzg.tracing.utils.SpUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zzg
 * @time 2018/11/26--17:16
 * @Des
 */
public class EasyHttpUtil {

    /**
     * post请求
     * @param url
     * @param hashMap
     * @param callBack
     */
    public static void request(String url, HashMap<String, Object> hashMap, final ICallBack callBack) {
        //未传参数，默认创建
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
//        //时间戳
//        String timeTamp = String.valueOf(System.currentTimeMillis() / 1000);
//        hashMap.put("app_key", APPKEY);
//        hashMap.put("timestamp", timeTamp);
//        try {
//            signCode = MD5.mapToSign(hashMap);
//        } catch (Exception e) {
//            Log.d("zzg", "传递参数加密出错" + url);
//        }
//        LogUtils.d("检验sign====" + signCode);
        //拼接参数
        PostRequest params = EasyHttp.post(url);
        Set<String> keySet = hashMap.keySet();
        Iterator<String> iter = keySet.iterator();
        String log_D = "--------------------------请求参数-----------------------------------\n";
        while (iter.hasNext()) {
            String key = iter.next();
            params.params(key, hashMap.get(key).toString());
            log_D = log_D + "======key：" + key + "---value:" + hashMap.get(key).toString() + "\n";
        }
//        params.params("sign", signCode);
//        log_D = log_D + "======key：sign---value:" + signCode;
//        //请求参数打印
        LogUtils.d(log_D);
        //请求地址
        LogUtils.d("requestURl======" + UrlConstants.BASEURL + url);
        //协议头
        String token = SpUtil.getString(BaseApplication.getmContxt(), SpUtil.USER_TOKEN, "");
        if (!TextUtils.isEmpty(token)) {
            params.headers("x-api-key", token);
            Log.e("token zzg", token);
        }
        params.execute(new SimpleCallBack<String>() {
            @Override
            public void onError(ApiException e) {
                LogUtils.e(e.toString());
                callBack.onFailed();

            }

            @Override
            public void onSuccess(String s) {
                LogUtils.d("请求返回结果-------------" + s);
                try {
                    BaseBean baseBean = JSON.parseObject(s, BaseBean.class);
                    if (NetResultUtil.isRequestOk(baseBean)) {
                        callBack.onSucess(baseBean.getData());
                    }
                } catch (Exception e) {
                    LogUtils.e("接口请求返回报错", e.toString());
                    callBack.onFailed();
                }

            }
        });
    }

}
