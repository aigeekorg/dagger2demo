package org.aigeek.mydaggerdemo.base;

/**
 * Created by yao on 2018/4/27.
 */
//mvp相关类
/**
 * 用于构建耦合了presenter的view对象
 * @param <T>
 */
public interface BaseView<T> {
    /**
     * 将presenter耦合到view中
     * @param presenter
     */
    void setPresenter(T presenter);
}
