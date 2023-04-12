package com.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);

    }
}
