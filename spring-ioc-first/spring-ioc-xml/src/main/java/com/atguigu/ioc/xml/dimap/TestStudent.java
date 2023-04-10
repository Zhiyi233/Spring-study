package com.atguigu.ioc.xml.dimap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-diref.xml");
        Student student = ac.getBean("studentp", Student.class);
        student.run();
    }
}
