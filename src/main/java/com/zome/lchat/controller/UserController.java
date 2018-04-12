package com.zome.lchat.controller;

import com.zome.lchat.entity.User;
import com.zome.lchat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/app/root")
public class UserController {
    @Resource(name = "userServiceImpl")
    UserService serService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    String login(String phone, String password){
        if (phone == null) {
            System.out.println("phone 不能为空");
            return "";
        }
        if (password == null) {
            System.out.println("password 不能为空");
            return "";
        }

        User user = serService.login(phone, password);

        if (user == null) {
            System.out.println("用户名或者密码错误");
            return "";
        }

        System.out.println("登录成功");
        return "{'登录成功'}";
    }

}
