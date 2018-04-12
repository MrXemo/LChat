package com.zome.lchat.service.impl;

import com.zome.lchat.dao.AdminMapper;
import com.zome.lchat.entity.Admin;
import com.zome.lchat.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;


    @Override
    public Admin loginAdmin(String userName, String password) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("phone", "13185878906");
        map.put("password", "123456");
        return adminMapper.loginVerify(map);
    }

    @Override
    public void loginSuccess(Admin admin) {
        System.out.println("登录成功");
    }
}
