package com.zome.lchat.test;

import org.springframework.stereotype.Component;

@Component
public class MyTestBean {
    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String mTestStr) {
        testStr = mTestStr;
    }
}
