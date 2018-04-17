package com.zome.lchat.controller;

import com.zome.lchat.entity.User;
import com.zome.lchat.service.UserService;
import com.zome.lchat.utils.JsonMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app/member")
public class UserController extends BaseController{
    @Resource(name = "userServiceImpl")
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonMessage login(String phone, String password){
        if (phone == null) {
            return JsonMessage.error("phone 不能为空");
        }
        if (password == null) {
            return JsonMessage.error("password 不能为空");
        }

        User user = userService.login(phone, password);

        if (user == null) {
            return JsonMessage.error("用户名或者密码错误");
        }

        return JsonMessage.success("token", user.getToken());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonMessage register(String username, String captcha, String password, String code, HttpServletRequest request){
        if (StringUtils.isEmpty(username)) {
            return JsonMessage.error("手机号不能为空");
        }
        if (StringUtils.isEmpty(captcha)){
            return JsonMessage.error("验证码不嫩为空");
        }
        if (userService.isExists(username)) {
            return JsonMessage.error("该手机号已经注册");
        }



//        String sendCode = null;
//        if (codes != null) {
//            for (VerificationCodeMapper verificationCode : codes) {
//                sendCode = verificationCode.getCode();
//            }
//        }

//        if (!captcha.equalsIgnoreCase(sendCode)) {
//            return JsonMessage.error("手机验证码不正确");
//        }
        return JsonMessage.success("");
    }

    @RequestMapping(value = "/send-code", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonMessage sendCode(String phone){
        System.out.println("phone : " + phone);
        // 1. 判断手机号码是否为空
        if (StringUtils.isEmpty(phone)) {
            return JsonMessage.error("手机号不能为空");
        }

//        userService.addVerification(phone);

        return JsonMessage.success("验证码发送成功！");
    }
}
