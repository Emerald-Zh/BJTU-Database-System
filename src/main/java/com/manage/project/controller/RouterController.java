package com.manage.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    //跳转页面的请求
    @RequestMapping({"/", "/loginPage"})
    public String doLoginByAccount() {
        return "login/login";
    }

    @RequestMapping("/registerPage")
    public String doRegisterPhone() {
        return "register/register";
    }

    @RequestMapping("/accountRegister")
    public String doRegisterAccount() {
        return "register/accountRegister";
    }

    @RequestMapping("/home")
    public String goHomePage() {
        return "view/home";
    }

    @RequestMapping("/userManage.html")
    public String goUserManagePage() {
        return "view/userManage";
    }

    @RequestMapping("/menuManage.html")
    public String goMenuManagePage() {
        return "view/menuManage";
    }

    @RequestMapping("/orderManage.html")
    public String toOrderManagePage() {
        return "view/orderManage";
    }

    @RequestMapping("/workerManage.html")
    public String toWorkerManagePage(){
        return "view/workerManage";
    }
}