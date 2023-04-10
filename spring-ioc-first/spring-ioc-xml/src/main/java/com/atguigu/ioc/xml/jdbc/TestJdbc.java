package com.atguigu.ioc.xml.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class TestJdbc {
    @Test
    public void demo1() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource druidDataSource = ac.getBean("druidDataSource", DruidDataSource.class);
        //DruidPooledConnection connection = druidDataSource.getConnection();
        //System.out.println(connection);
        System.out.println(druidDataSource.getUrl());

    }

    public void demo2(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
        druidDataSource.setName("root");
        druidDataSource.setPassword("abc123");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }
}
