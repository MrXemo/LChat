package com.zome.lchat.service;


import com.zome.lchat.entity.User;
import com.zome.lchat.entity.VerificationCode;

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
    VerificationCode findCode(String phone);

    /**
     * 添加用户的验证码实体
     */
    void addVerification(String phone);

    /**
     * 更新验证码
     */
    void updateVerification(String phone);

    /**
     * 注册账号
     */
    void register(String phone, String password);

    /**
     * 获取会员信息
     */
    User find(Integer id);

    /**
     * 获取当前登录会员(token机制,手机应用)
     *
     * @return 当前登录会员，若不存在则返回null
     */
    User getCurrentByToken();

}
