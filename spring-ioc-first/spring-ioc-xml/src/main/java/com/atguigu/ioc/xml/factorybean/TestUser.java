package com.atguigu.ioc.xml.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-factorybean.xml");

        User user = (User) ac.getBean("user");
        System.out.println(user);

    }
}
