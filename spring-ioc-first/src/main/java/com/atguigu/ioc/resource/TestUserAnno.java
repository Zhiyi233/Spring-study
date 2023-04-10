package com.atguigu.ioc.resource;

import com.atguigu.ioc.conf.springConf;
import com.atguigu.ioc.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserAnno {
    public static void main(String[] args) {
        //全注解的用法
        ApplicationContext context = new AnnotationConfigApplicationContext(springConf.class);
        UserController userController = context.getBean(UserController.class);
        userController.add();
    }
}
