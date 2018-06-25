package org.aigeek.mydaggerdemo.testscope.testscopepkg;

import javax.inject.Inject;

/**
 * Created by yao on 2018/5/2.
 */

public class TestScopeDataRepository implements TestScopeDataSource{


    public TestScopeDataSource getTestRemoteScopeDataSource() {
        return mTestRemoteScopeDataSource;
    }

    public TestScopeDataSource getTestLocalScopeDataSource() {
        return mTestLocalScopeDataSource;
    }

    private final TestScopeDataSource mTestRemoteScopeDataSource;
    private final TestScopeDataSource mTestLocalScopeDataSource;

    @Inject TestScopeDataRepository(@Remote TestScopeDataSource testRemoteScopeDataSource,
                                    @Local TestScopeDataSource testLocalScopeDataSource){
        mTestRemoteScopeDataSource = testRemoteScopeDataSource;
        mTestLocalScopeDataSource = testLocalScopeDataSource;
    }


    @Override
    public void getTestScopeName() {
        mTestRemoteScopeDataSource.getTestScopeName();
        mTestLocalScopeDataSource.getTestScopeName();
    }
}
