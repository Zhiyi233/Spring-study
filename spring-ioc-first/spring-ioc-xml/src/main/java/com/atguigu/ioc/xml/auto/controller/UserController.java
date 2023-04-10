package com.atguigu.ioc.xml.auto.controller;

import com.atguigu.ioc.xml.auto.service.UserService;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法执行了");
        userService.addUserService();
//        UserService userService = new UserServiceImpl();
//        userService.addUserService();
    }
}
