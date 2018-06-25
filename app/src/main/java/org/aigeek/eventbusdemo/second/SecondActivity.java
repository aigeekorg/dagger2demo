package org.aigeek.eventbusdemo.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.aigeek.eventbusdemo.bean.TestBean;
import org.aigeek.mydaggerdemo.R;
import org.aigeek.eventbusdemo.bean.ClickBean;
import org.greenrobot.eventbus.EventBus;
//eventbus demo相关类
public class SecondActivity extends Activity {

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTextView = findViewById(R.id.text_second_activity);
        mButton = findViewById(R.id.btn_second_activty);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ClickBean("from second Activity"));
                EventBus.getDefault().post(new TestBean(123));
            }
        });

    }
}
