package org.aigeek.mydaggerdemo.testscope.testscopepkg;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by yao on 2018/5/2.
 */

public class TestLocalScopeDataSource implements TestScopeDataSource {

    @Inject
    public TestLocalScopeDataSource(){
        Log.i("testscope","this is TestLocalScopeDataSource");
    }

    @Override
    public void getTestScopeName() {
        Log.i("testscope","this is TestLocalScopeDataSource");
    }
}
