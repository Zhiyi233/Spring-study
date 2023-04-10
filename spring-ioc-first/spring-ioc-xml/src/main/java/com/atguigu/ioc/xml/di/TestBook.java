package com.atguigu.ioc.xml.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
    @org.junit.Test
    public void testSet(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");

        Book book = context.getBean("book",Book.class);
        System.out.println(book);
    }
    @Test
    public void testCon(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");

        Book book = context.getBean("bookCon",Book.class);
        System.out.println(book);
    }
}
