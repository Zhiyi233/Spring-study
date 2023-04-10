package com.atguigu.ioc.resource.controller;

import org.springframework.stereotype.Controller;
import com.atguigu.ioc.resource.service.UserService;

import javax.annotation.Resource;

//不写名字就是默认的小写开头的类名
@Controller(value = "myUserController")
public class UserController {

    @Resource(name = "myUserServiceImpl")
    private UserService userService;

    public void add(){
        System.out.println("Controller.....");
        userService.addService();
    }
}
