package com.zzg.tracing.net;

/**
 * @author zzg
 * @time 2018/11/26--17:17
 * @Des
 */
public interface ICallBack {
    void onFailed();
    void onSucess(String data);
}
