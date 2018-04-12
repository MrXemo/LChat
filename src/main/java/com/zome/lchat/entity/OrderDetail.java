package com.zome.lchat.entity;

public class OrderDetail {
    /** 主鍵，訂單明细表Id */
    private Integer id;
    /** 訂單Id */
    private Integer ordersId;
    /** 商品id */
    private Integer itemsId;
    /** 商品购买数量 */
    private Integer itemsNum;
    // 明细对应的商品信息
    private Items items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer mId) {
        id = mId;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer mOrdersId) {
        ordersId = mOrdersId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer mItemsId) {
        itemsId = mItemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer mItemsNum) {
        itemsNum = mItemsNum;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items mItems) {
        items = mItems;
    }
}
