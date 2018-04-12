package com.zome.lchat.service;

import com.zome.lchat.entity.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> findUserOrders(Integer id);
}
