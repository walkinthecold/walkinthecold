package com.walkinthecold.activity;

import com.walkinthecold.R;
import com.walkinthecold.base.BaseActivity;
import com.walkinthecold.base.BasePresenter;

public class MainActivity extends BaseActivity {

    @Override
    protected int getRelayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }
}
