package com.zome.lchat.test;


import com.zome.lchat.dao.AdminMapper;
import com.zome.lchat.dao.OrderDetailMapper;
import com.zome.lchat.dao.OrderMapper;
import com.zome.lchat.dao.UserMapper;
import com.zome.lchat.entity.Admin;
import com.zome.lchat.entity.OrderDetail;
import com.zome.lchat.entity.Orders;
import com.zome.lchat.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DaoText {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper detailMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void test(){
        List<Orders> orders =  orderMapper.findAllOrder(1);
        System.out.println("orders.size() : " + orders.size());
        for (Orders order : orders) {
            System.out.println(order.getId() + "  " + order.getOrderDetails().get(0).getItems().getName() + "  " + order.getUser().getAddress());
        }
    }

    @Test
    public void test1(){
        OrderDetail detail = detailMapper.findOrderDetails(14);
        System.out.println(detail.getId() + "  " + detail.getItemsNum() + "  " + detail.getItems().getName()
        + "  " + detail.getItems().getPrice() + "  " + detail.getItems().getDetail());
    }

    @Test
    public void login(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("phone", "13185878906");
        map.put("password", "123456");
        Admin user = adminMapper.loginVerify(map);
        if (user == null) {
            System.out.println("找不到user");
        }
        System.out.println(user.getUserName() + user.getPassword());
    }
}
