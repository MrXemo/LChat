package com.zome.lchat.entity;

import java.util.Date;

public class Admin {
    private Integer id;
    private String userName;
    private String password;
    private String ip;
    private Date loginDatatime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer mId) {
        id = mId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String mUserName) {
        userName = mUserName;
    }

    public Date getLoginDatatime() {
        return loginDatatime;
    }

    public void setLoginDatatime(Date mLoginDatatime) {
        loginDatatime = mLoginDatatime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String mPassword) {
        password = mPassword;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String mIp) {
        ip = mIp;
    }
}
