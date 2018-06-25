package org.aigeek.mydaggerdemo.testscope.testscopepkg;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by yao on 2018/5/2.
 */

public class TestRemoteScopeDataSource implements TestScopeDataSource {


    @Inject
    public TestRemoteScopeDataSource(){
        Log.i("testscope","this is TestRemoteScopeDataSource");
    }

    @Override
    public void getTestScopeName() {
        Log.i("testscope","this is TestRemoteScopeDataSource");
    }
}
