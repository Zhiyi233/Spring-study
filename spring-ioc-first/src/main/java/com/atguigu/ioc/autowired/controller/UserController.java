package com.atguigu.ioc.autowired.controller;

import com.atguigu.ioc.autowired.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //Autowired可以在属性，set方法，构造器，形参上注入都可以完成同样的效果
//    @Autowired
//    private UserService userService;

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

//    public UserController(){
//
//    }

    public void add(){
        System.out.println("Controller.....");
        userService.addService();
    }
}
