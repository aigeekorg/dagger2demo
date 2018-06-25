package org.aigeek.mydaggerdemo.testscope.testscopepkg;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yao on 2018/5/2.
 */

@Module
public class TestScopeDataSourceModule {

    @Provides
    @Local
    TestScopeDataSource provideTestLocalScopeDataSource(){
        return new TestLocalScopeDataSource();
    }

    @Provides
    @Remote
    TestScopeDataSource provideTestRemoteScopeDataSource(){
        return new TestRemoteScopeDataSource();
    }

}
