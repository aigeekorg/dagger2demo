package org.aigeek.mydaggerdemo.main;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yao on 2018/4/27.
 */
//dagger2 结构类，module用于提供对象等

@Module
public class MainPresenterModule {

    private final MainContract.MainViewInterf mView;
    //初始化的时候会被实例化。需要提供成员变量view以生成可用的Module对象
    public MainPresenterModule(MainContract.MainViewInterf view){
        mView = view;
    }

    @Provides
    MainContract.MainViewInterf provideMainViewInterf(){
        return mView;
    }

}
