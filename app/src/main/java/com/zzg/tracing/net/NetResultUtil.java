package com.zzg.tracing.net;

import com.zzg.tracing.utils.ToastUtils;

/**
 * Created by apple on 2017/12/19.
 */

public class NetResultUtil {
    public static final String RESULT_OK = "success";
    public static final String RESULT_FAIL = "failed";

    public static boolean isRequestOk(BaseBean baseBean) {
        if (RESULT_OK.equals(baseBean.getStatus().getState())) {
            return true;
        } else {
            String msg = baseBean.getStatus().getMessage();
            ToastUtils.getInstanc().showToast(msg);
//            LoadingCustom.dismissprogress();
//            if (LOGINOUT.equals(msg)) {
//                EventBus.getDefault().post(new EventMessage(EventConstant.LOGINBYOTHERDERVICES, null));
//                ToastUtils.showShort("当前用户已在其他设备登录，为保证您的信息安全，请重新登录");
//            } else {
//                ToastUtils.showShort(baseBean.getMsg());
//            }
            return false;
        }
    }


}
