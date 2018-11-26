package com.zzg.tracing.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * @author zzg
 * @time 2018/11/26--17:09
 * @Des
 */
public abstract class BaseActivity extends AppCompatActivity {

    /***是否显示标题栏*/
    private boolean isshowtitle = true;
    /***是否显示标题栏*/
    private boolean isshowstate = false;
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    //当前视频id
    private int mCurIncomingId;

    private boolean isTop = false;

    /**
     * 是否设置标题栏
     *
     * @return
     */
    public void setTitle(boolean ishow) {
        isshowtitle = ishow;
    }

    /**
     * 设置是否显示状态栏
     *
     * @param ishow
     */
    public void setState(boolean ishow) {
        isshowstate = ishow;
    }


    @Override
    protected void onStart() {
        super.onStart();
        isTop = true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isshowtitle) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        isTop = true;
        if (isshowstate) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        //设置布局
        initDataBinding();
        //初始化控件
        initView();
        //设置数据
        initData();
    }


    @Override
    protected void onStop() {
        super.onStop();
        isTop = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 设置布局
     *
     * @return
     */
    public abstract void initDataBinding();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();
}
