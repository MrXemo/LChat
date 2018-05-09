package com.zome.lchat.controller;

import com.zome.lchat.entity.User;
import com.zome.lchat.entity.VerificationCode;
import com.zome.lchat.service.UserService;
import com.zome.lchat.utils.JsonMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/app/member")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    /**
     * 登录
     *
     * @param phone    账号
     * @param password 密码
     * @return json
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonMessage login(String phone, String password) {
        if (phone == null) {
            return JsonMessage.error("手机号码不能为空");
        }
        if (password == null) {
            return JsonMessage.error("密码不能为空");
        }
        User user = userService.login(phone, password);
        if (user == null) {
            return JsonMessage.error("手机号或者密码错误");
        }
        return JsonMessage.success("token", user.getToken());
    }


    /**
     * 注册
     *
     * @param phone    手机号码
     * @param captcha  验证号码
     * @param password 密码
     * @return json
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public JsonMessage register(String phone, String captcha, String password, HttpServletRequest request) {
        if (StringUtils.isEmpty(phone)) {
            return JsonMessage.error("手机号不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return JsonMessage.error("密码不能为空");
        }
        if (StringUtils.isEmpty(captcha)) {
            return JsonMessage.error("验证码不能为空");
        }
        if (userService.isExists(phone)) {
            return JsonMessage.error("该手机号已经注册");
        }
        VerificationCode code = userService.findCode(phone);
        if (code != null && code.getCode().toString().equals(captcha)) {
            userService.register(phone, password);
            return JsonMessage.success("注册成功");
        } else {
            return JsonMessage.error("验证码不正确");
        }
    }

    /**
     * 发送验证
     *
     * @param phone 手机号
     * @return
     */
    @RequestMapping(value = "/send-code", method = RequestMethod.POST)
    @ResponseBody
    public JsonMessage sendCode(String phone) {
        System.out.println("phone : " + phone);
        // 1. 判断手机号码是否为空
        if (StringUtils.isEmpty(phone)) {
            return JsonMessage.error("手机号不能为空");
        }
        VerificationCode verificationCode = userService.findCode(phone);

        if (verificationCode == null) {
            userService.addVerification(phone);
        } else {
            Date now = new Date();
            long minute = 1000 * 60;
            if (now.getTime() - verificationCode.getSendDate().getTime() > minute) {
                userService.updateVerification(phone);
            } else {
                return JsonMessage.error("验证码已发送，请稍等");
            }
        }

        return JsonMessage.success("验证码发送成功！");
    }

    /**
     * 个人信息
     */
    @RequestMapping(value = "/member_message", method = RequestMethod.GET)
    @ResponseBody
    public JsonMessage getMember_message() {
        User user = userService.getCurrentByToken();
        return JsonMessage.success("name", user.getUsername(), "phone", user.getPhone());
    }
}
