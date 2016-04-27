package com.walkinthecold;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by admin on 2016/4/27 0027.
 */
public class AnotherActivity extends Activity {
    @InjectView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {
        EventBus.getDefault().post(new EventMsg("you are smart"));
    }
}
