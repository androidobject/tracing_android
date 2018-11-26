package com.zzg.tracing.ui;

import android.databinding.DataBindingUtil;

import com.zzg.tracing.R;
import com.zzg.tracing.base.BaseActivity;
import com.zzg.tracing.databinding.ActivityLoginBinding;

/**
 * @author zzg
 * @time 2018/11/26--17:51
 * @Des
 */
public class LoginActivity extends BaseActivity {


    private ActivityLoginBinding binding;

    /**
     * 设置布局
     *
     * @return
     */
    @Override
    public void initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    /**
     * 初始化布局
     */
    @Override
    public void initView() {

    }

    /**
     * 设置数据
     */
    @Override
    public void initData() {

    }
}
