package com.atguigu.ioc.xml.ditest;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-ditest.xml");

        Employee emp = context.getBean("emp3", Employee.class);
        emp.work();
    }

    /**
     * 测试数组属性注入是否成功
     */
    @Test
    public void testArrayDi(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-di-array.xml");
        Employee emp = ac.getBean("emp", Employee.class);
        emp.work();
    }

    /**
     * 测试集合属性注入是否成功
     */
    @Test
    public void testSetDi(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-list-di.xml");
        Department dept = ac.getBean("dept", Department.class);
        dept.info();
    }
}
