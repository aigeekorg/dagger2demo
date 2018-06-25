package org.aigeek.mydaggerdemo.main;

import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by yao on 2018/4/27.
 */
//mvp相关类
public class MainPresenter implements MainContract.MainPresenterInterf{

    @NonNull
    private final MainContract.MainViewInterf mView;

    /**
     * 构造方法，dagger在生成对象时调用，参数由module中的provides注解提供
     */
    @Inject MainPresenter(MainContract.MainViewInterf view){
        mView = view;
    }

    /**
     * 一般方法，在dagger自动调用
     */
    @Inject
    void setupListener(){
        mView.setPresenter(this);
    }

    /**
     * 一般方法，在dagger自动调用
     */
    @Inject
    void setupOtherthings(){
    }

    @Override
    public void start() {
        mView.setText("presenter set: main fragment");
    }

}
