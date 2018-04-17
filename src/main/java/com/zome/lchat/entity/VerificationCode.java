package com.zome.lchat.entity;

import java.util.Date;

public class VerificationCode {
    private Integer id;
    /**
     * 申请验证码的手机号码
     */
    private String phone;
    /**
     * 已发送验证码
     */
    private Integer code;
    /**
     * 发送验证码的时间
     */
    private Date sendDate;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String mPhone) {
        phone = mPhone;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer mCode) {
        code = mCode;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date mSendDate) {
        sendDate = mSendDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer mId) {
        id = mId;
    }
}
