package org.aigeek.eventbusdemo.bean;

/**
 * Created by yao on 2018/4/28.
 */
//eventbus demo相关类
public class ClickBean {

    public ClickBean(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    String msg;

}
