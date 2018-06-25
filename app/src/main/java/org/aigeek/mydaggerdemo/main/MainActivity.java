package org.aigeek.mydaggerdemo.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.aigeek.mydaggerdemo.R;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

//原生组件类
public class MainActivity extends AppCompatActivity{

    TextView mTextView;

    @Inject MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text);

        MainFragment mainFragment = (MainFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment == null){
            mainFragment = MainFragment.newInstance();
            addFragmentToActivity(getFragmentManager(),mainFragment,R.id.contentFrame);
        }

        DaggerMainComponent.builder()
                .mainPresenterModule(new MainPresenterModule(mainFragment))
                .build()
                .inject(this);


        Log.i("test","mMainPresenter address="+mMainPresenter);
    }

    private void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                       @NonNull MainFragment mainFragment,
                                       @NonNull int fragmentId) {
        checkNotNull(fragmentManager);
        checkNotNull(mainFragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragmentId,mainFragment);
        transaction.commit();
    }
}
