package com.zome.lchat.entity.enumerate;

/**
 * 栏目类别
 */
public enum  Classify {


    video(0, "视频"),

    audio(1, "音频");

    private int code;
    private String classify;

    Classify(int mCode, String mClassify) {
        code = mCode;
        classify = mClassify;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int mCode) {
        code = mCode;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String mClassify) {
        classify = mClassify;
    }
}
