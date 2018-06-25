package org.aigeek.mydaggerdemo.testscope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yao on 2018/4/27.
 */
//dagger2 结构类，module用于提供对象等

@Module
public class TestScopePresenterModule {

    private final TestScopeContract.MainViewInterf mView;
    //初始化的时候会被实例化。需要提供成员变量view以生成可用的Module对象
    public TestScopePresenterModule(TestScopeContract.MainViewInterf view){
        mView = view;
    }

    @Provides
    TestScopeContract.MainViewInterf provideMainViewInterf(){
        return mView;
    }

}
