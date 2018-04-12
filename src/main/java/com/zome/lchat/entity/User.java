package com.zome.lchat.entity;

import java.util.Date;
import java.util.List;

public class User {

    private Integer id;
    // 姓名
    private String username;
    // 性别
    private String sex;
    // 地址
    private String address;
    // 生日
    private Date birthday;
    // 登录手机
    private String phone;
    // 登录密码
    private String password;
    // 用户创建的订单列表
    private List<Orders> ordersList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer mId) {
        id = mId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String mUsername) {
        username = mUsername;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String mSex) {
        sex = mSex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String mAddress) {
        address = mAddress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date mBirthday) {
        birthday = mBirthday;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> mOrdersList) {
        ordersList = mOrdersList;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String mPhone) {
        phone = mPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String mPassword) {
        password = mPassword;
    }
}
