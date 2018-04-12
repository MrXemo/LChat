package com.zome.lchat.entity;

import java.util.Date;
import java.util.List;

public class Orders {
    /** 主键订单Id */
    private Integer id;
    /** 下单用户id */
    private Integer userId;
    /** 订单号 */
    private String number;
    /** 创建订单时间 */
    private Date createTime;
    /** 备注 */
    private String note;
    // 用户信息
    private User user;
    // 订单明细
    private List<OrderDetail> orderDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer mId) {
        id = mId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer mUserId) {
        userId = mUserId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String mNumber) {
        number = mNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date mCreateTime) {
        createTime = mCreateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String mNote) {
        note = mNote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User mUser) {
        user = mUser;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> mOrderDetails) {
        orderDetails = mOrderDetails;
    }
}
