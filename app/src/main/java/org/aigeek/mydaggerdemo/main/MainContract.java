package org.aigeek.mydaggerdemo.main;

/**
 * Created by yao on 2018/4/27.
 */
//mvp相关类
import org.aigeek.mydaggerdemo.base.BasePresenter;
import org.aigeek.mydaggerdemo.base.BaseView;

/**
 * 统一presenter和view(如这里是MainFragment不是MainActivity)的构建者
 * 如果MainActivity不再作为view，则通过dagger注解的方式获取presenter
 */
public interface MainContract {

    interface MainViewInterf extends BaseView<MainPresenter>{
        String getText();
        void setText(String s);
    }
    interface MainPresenterInterf extends BasePresenter{
    }
}
