package com.zome.lchat.service.impl;

import com.zome.lchat.dao.UserMapper;
import com.zome.lchat.dao.VerificationCodeMapper;
import com.zome.lchat.entity.User;
import com.zome.lchat.entity.VerificationCode;
import com.zome.lchat.entity.enumerate.Gender;
import com.zome.lchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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
    public VerificationCode findCode(String phone) {
        return verificationCodeMapper.findCode(phone);
    }

    @Override
    public void addVerification(String phone) {
        Map map = new HashMap();
        map.put("phone", phone);
        map.put("code", Math.random() * 900000 + 100000);
        map.put("send_date", new Date());
        verificationCodeMapper.addCode(map);
    }

    @Override
    public void updateVerification(String phone) {
        Map map = new HashMap();
        map.put("phone", phone);
        map.put("code", Math.random() * 900000 + 100000);
        map.put("send_date", new Date());
        verificationCodeMapper.updateCode(map);
    }

    @Override
    @Transactional
    public void register(String phone, String password) {
        User user = new User();
        user.setAddress("");
        user.setUsername("Yun" + Math.random() * 9000 + 1000);
        user.setPhone(phone);
        user.setPassword(password);
        user.setGender(Gender.MALE);
        user.setAvatar("http://www.qqzhi.com/uploadpic/2014-05-14/051120936.jpg");
        user.setToken("");
        userMapper.register(user);
    }

    @Override
    public User find(Integer id) {
        return null;
    }

    @Override
    public User getCurrentByToken() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
           /* HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            String token = request.getParameter("token");
            return findByToken2(token);*/
           HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
           String token = request.getParameter("token");
           return userMapper.findByToken(token);
        }
        return null;
    }

}
