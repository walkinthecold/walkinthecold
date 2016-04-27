package com.walkinthecold;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @InjectView(R.id.btn)
    Button btn;
    @InjectView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {
        Intent intent = new Intent(this, AnotherActivity.class);
        startActivity(intent);
        //EventBus.getDefault().post(new EventMsg("duola"));
    }

    /*
     *   onEvent                    同一个线程
     *   onEventBackgroundThread    子线程接受
     *   onEventAsync               创建新的线程
     */
    @Subscribe
    public void onEventMainThread(EventMsg eventMsg) {
        tv.setText(eventMsg.getMsg());
        Toast.makeText(this, eventMsg.getMsg(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
