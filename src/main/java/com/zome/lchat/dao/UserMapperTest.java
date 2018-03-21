package com.zome.lchat.dao;

import com.zome.lchat.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class UserMapperTest {
    private ApplicationContext applicationContext;
    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");//加载spring配置文件
        userMapper = applicationContext.getBean(UserMapper.class);//在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setId(2);
        user.setEmail("234234@qq.com");
        user.setPassword("123456");
        user.setUsername("小米");
        user.setStatus(12);
        user.setRegip("192.168.10.1");
        user.setRole("白金会员");
        user.setRegtime(new Date());
        int result = userMapper.insertSelective(user);
        System.out.println(result);
        assert (result == 1);

    }

}
