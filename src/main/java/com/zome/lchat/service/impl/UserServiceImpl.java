package com.zome.lchat.service.impl;

import com.zome.lchat.dao.UserMapper;
import com.zome.lchat.dao.VerificationCodeMapper;
import com.zome.lchat.entity.User;
import com.zome.lchat.entity.VerificationCode;
import com.zome.lchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    VerificationCodeMapper verificationCodeMapper;

    @Transactional
    public User login(String phone, String password) {
        System.out.println("phone : " + phone + " password : " + password);
        Map<String, String> map = new HashMap<String, String>();
        map.put("phone", phone);
        map.put("password", password);
        User user = userMapper.login(map);
        if (user != null) {
            System.out.println(user.getUsername());
        } else {
            System.out.println("user等于空");
        }
        return user;
    }

    @Transactional
    public Boolean isExists(String username){
        return userMapper.isExists(username);
    }

    @Override
    public Integer findCode(String code) {
        return null;
    }

    @Override
    public void addVerification(String phone) {
        Map map = new HashMap();
        map.put("phone", phone);
        map.put("code", Math.random() * 1000000);
        map.put("send_date", new Date());
        verificationCodeMapper.addCode(map);
    }

    @Override
    public void updateVerification(String phone) {

    }
}
