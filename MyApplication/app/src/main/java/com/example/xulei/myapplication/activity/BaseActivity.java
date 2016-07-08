package com.example.xulei.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by xulei on 2016/5/20.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout();
        initView();
    }

    public void onClick(View v) {
        onClickEvent(v);
    }

    /**
     * 1,初始化页面布局
     */
    public abstract void setContentLayout();

    /**
     * 2.实例化布局文件/组件
     */
    public abstract void initView();

    /**
     * 3.点击事件
     */
    public abstract void onClickEvent(View view);

}
