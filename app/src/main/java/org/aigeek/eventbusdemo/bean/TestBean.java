package org.aigeek.eventbusdemo.bean;

/**
 * Created by yao on 2018/4/28.
 */

public class TestBean {
    public TestBean(int test) {
        this.test = test;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    int test;
}
