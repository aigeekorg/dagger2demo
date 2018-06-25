package org.aigeek.mydaggerdemo.testscope;

import org.aigeek.mydaggerdemo.testscope.testscopepkg.TestScopeDataRepository;
import org.aigeek.mydaggerdemo.testscope.testscopepkg.TestScopeDataSourceModule;

import dagger.Component;

/**
 * Created by yao on 2018/4/27.
 */
//dagger2 结构类

/**
 * Component是@Inject和@Module之间的桥梁，将module提供的对象等使用inject注入到需要的对象中
 */
@Component(modules = {TestScopePresenterModule.class,TestScopeDataSourceModule.class})
public interface TestScopeComponent {
    /**
     * 指，将module注入到MainActivity中
     */
    void inject(TestScopeActivity mainActivity);

    TestScopeDataRepository getTestScopeDataRepository();
}
