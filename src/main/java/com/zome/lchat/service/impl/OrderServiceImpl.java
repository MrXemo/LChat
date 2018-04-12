package com.zome.lchat.service.impl;


import com.zome.lchat.dao.OrderMapper;
import com.zome.lchat.entity.Orders;
import com.zome.lchat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Orders> findUserOrders(Integer id) {
        return orderMapper.findAllOrder(id);
    }
}
