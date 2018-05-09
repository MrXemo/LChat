package com.zome.lchat.dao;


import com.zome.lchat.entity.User;

import java.util.Map;

public interface UserMapper {
    /**
     * 登录
     */
    User login(Map map);

    /**
     * 是否存在
     */
    Boolean isExists(String username);

    /**
     * 注册
     */
    void register(User user);

    /**
     * 根据token获取USER
     */
    User findByToken(String token);
}
