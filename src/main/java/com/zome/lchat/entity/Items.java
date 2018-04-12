package com.zome.lchat.entity;

import java.util.Date;

public class Items {
    /** 商品表主键Id */
    private Integer id;
    /** 商品名称 */
    private String name;
    /** 商品定价 */
    private float price;
    /** 商品描述 */
    private String detail;
    /** 商品图片 */
    private String picture;
    /** 生产日期 */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer mId) {
        id = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String mName) {
        name = mName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float mPrice) {
        price = mPrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String mDetail) {
        detail = mDetail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String mPicture) {
        picture = mPicture;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date mCreateTime) {
        createTime = mCreateTime;
    }
}
