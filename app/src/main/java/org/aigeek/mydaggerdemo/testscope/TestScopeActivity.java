package org.aigeek.mydaggerdemo.testscope;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.aigeek.mydaggerdemo.R;
import org.aigeek.mydaggerdemo.testscope.testscopepkg.TestScopeDataRepository;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

//原生组件类
public class TestScopeActivity extends AppCompatActivity{

    TextView mTextView;

    @Inject
    TestScopePresenter mTestScopePresenter;
    @Inject
    TestScopePresenter mMainPresenterTest1;

    @Inject
    TestScopeDataRepository mTestScopeDataRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testscope);
        mTextView = findViewById(R.id.text);

        TestScopeFragment testScopeFragment = (TestScopeFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (testScopeFragment == null){
            testScopeFragment = TestScopeFragment.newInstance();
            addFragmentToActivity(getFragmentManager(), testScopeFragment,R.id.contentFrame);
        }

        DaggerTestScopeComponent
                .builder()
                .testScopePresenterModule(new TestScopePresenterModule(testScopeFragment))
                .build()
                .inject(this);

        Log.i("test","mTestScopePresenter address="+ mTestScopePresenter);
        Log.i("test","mMainPresenterTest1 address="+ mMainPresenterTest1);

        mTestScopeDataRepository.getTestScopeName();

        Log.i("test","mTestLocalScopeDataSource address="+
        mTestScopeDataRepository.getTestLocalScopeDataSource());

        Log.i("test","mTestRemoteScopeDataSource address="+
        mTestScopeDataRepository.getTestRemoteScopeDataSource());
    }

    private void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                       @NonNull TestScopeFragment testScopeFragment,
                                       @NonNull int fragmentId) {
        checkNotNull(fragmentManager);
        checkNotNull(testScopeFragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragmentId, testScopeFragment);
        transaction.commit();
    }
}
