package com.zome.lchat.controller;

import com.zome.lchat.entity.Admin;
import com.zome.lchat.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "adminServiceImpl")
    private AdminService adminService;

    @RequestMapping(value = "/index")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginAdmin(HttpServletRequest request, String userName, String password){
        Admin admin = adminService.loginAdmin(userName, password);
        if (admin == null) {
            System.out.println("admin 为空");
            return new ModelAndView("login", "error", "用户名或密码错误。");
        } else {
            adminService.loginSuccess(admin);
            return new ModelAndView("main");
        }
    }
}
