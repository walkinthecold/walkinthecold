package com.walkinthecold.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.walkinthecold.mvp.IView;

/**
 * @创建者 duanp
 * @创建时间 2017/2/24 0024
 * @描述 ${TODO}
 */

public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements IView {
    protected View view;
    protected P    mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        initData();
        initEvent();
        initPresenter();
    }

    private View getView() {
        view = View.inflate(this, getRelayoutId(), null);
        return view;
    }

    private void initPresenter() {
        mPresenter = loadPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract int getRelayoutId();

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract P loadPresenter();

}
