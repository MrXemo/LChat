package com.zome.lchat.service;


import com.zome.lchat.entity.User;

public interface UserService {

    /**
     * 用户登录
     */
    User login(String phone, String password);

    /**
     * 判断是否存在
     */
    Boolean isExists(String username);

    /**
     * 获取用户的验证码
     */
    Integer findCode(String code);

    /**
     * 添加用户的验证码实体
     */
    void addVerification(String phone);

    /**
     * 更新验证码
     */
    void updateVerification(String phone);
}
