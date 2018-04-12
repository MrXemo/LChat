package com.zome.lchat.controller;

import com.zome.lchat.service.OrderService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class OrderController {
    @Resource(name = "orderServiceImpl")
    OrderService orderService;

}
