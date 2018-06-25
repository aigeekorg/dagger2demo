package org.aigeek.eventbusdemo.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.aigeek.eventbusdemo.bean.TestBean;
import org.aigeek.mydaggerdemo.R;
import org.aigeek.eventbusdemo.bean.ClickBean;
import org.aigeek.eventbusdemo.second.SecondActivity;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by yao on 2018/4/28.
 */
//eventbus demo相关类
//1.FistActivity点击启动SecondActivity;
// 2.SecondActivity点击后,发送msg给FirstActivity;
// 3.FirstActivity接收到消息后，弹出toast并设置到它的button中;//根据消息对象的类不同，接收者不同
public class FirstActivity extends Activity {

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mTextView = findViewById(R.id.text_first_activity);
        mButton = findViewById(R.id.btn_first_activity);

        EventBus.getDefault().register(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///FirstActivity.this 包含该匿名内部类的这个FirstActivity实例
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    //放在主线程，防止内存泄漏
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStringEventMainThread(ClickBean clickBean){
        String msg = clickBean.getMsg();
        Toast.makeText(this,"FirstActivity string event:"+msg,Toast.LENGTH_SHORT).show();
        mButton.setText(msg);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onIntEventMainThread(TestBean testBean){
        int msg = testBean.getTest();
        Toast.makeText(this,"FirstActivity int event:"+msg,Toast.LENGTH_SHORT).show();
    }



}
