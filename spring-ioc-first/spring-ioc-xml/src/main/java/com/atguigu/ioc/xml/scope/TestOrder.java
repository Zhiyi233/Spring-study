package com.atguigu.ioc.xml.scope;

import com.atguigu.ioc.xml.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-scope.xml");
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);
        Order order1 = applicationContext.getBean("order", Order.class);
        System.out.println(order1);

        User user1 = applicationContext.getBean("user", User.class);
        User user2 = applicationContext.getBean("user", User.class);
        user1.run();
        user2.run();
        System.out.println(user1);
        System.out.println(user2);
    }
}
