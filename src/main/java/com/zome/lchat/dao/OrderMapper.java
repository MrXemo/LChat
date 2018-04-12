package com.zome.lchat.dao;


import com.zome.lchat.entity.Orders;

import java.util.List;

public interface OrderMapper {

    public List<Orders> findAllOrder(Integer id);

}
