package com.zome.lchat.service.impl;

import com.zome.lchat.dao.UserMapper;
import com.zome.lchat.entity.User;
import com.zome.lchat.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

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
}
