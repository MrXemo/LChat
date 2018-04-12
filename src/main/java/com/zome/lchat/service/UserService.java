package com.zome.lchat.service;


import com.zome.lchat.entity.User;

public interface UserService {

    //用户登录
    User login(String phone, String password);
}
