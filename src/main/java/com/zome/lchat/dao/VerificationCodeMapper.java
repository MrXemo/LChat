package com.zome.lchat.dao;

import com.zome.lchat.entity.VerificationCode;

import java.util.Map;

public interface VerificationCodeMapper {
    /**
     * 验证验证码
     */
    VerificationCode findCode(String phone);

    /**
     * 更新验证码
     */
    void updateCode(Map map);

    /**
     * 添加验证码
     */
    void addCode(Map map);
}
