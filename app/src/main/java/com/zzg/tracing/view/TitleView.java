package com.zzg.tracing.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzg.tracing.R;

/**
 * @author zzg
 * @time 2018/11/26--18:07
 * @Des
 */
public class TitleView extends RelativeLayout implements View.OnClickListener {
    private View view;
    //点击返回
    private ImageView leftBtn;
    //右边图标，标题
    private TextView tv_right, tv_title;

    private OnClickListener leftClick;
    private OnClickListener rightClick;


    public TitleView(Context context) {
        super(context);
        init();
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        view = inflater.inflate(R.layout.app_title, null);
        this.addView(view, layoutParams);
        leftBtn = view.findViewById(R.id.iv_back);
        tv_right = view.findViewById(R.id.tv_right);
        tv_title = view.findViewById(R.id.tv_title);
        leftBtn.setOnClickListener(this);
        tv_right.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

    }

}
