package com.zome.lchat.entity.enumerate;

public enum Gender {

    MALE(0, "男"),

    female(1, "女");

    private int code;
    private String sex;

    Gender(int code, String sex) {
        this.code = code;
        this.sex = sex;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int mCode) {
        code = mCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String mSex) {
        sex = mSex;
    }
}