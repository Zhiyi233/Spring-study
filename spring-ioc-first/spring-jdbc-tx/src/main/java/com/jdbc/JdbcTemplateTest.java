package com.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class JdbcTemplateTest {
    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        /*
        添加操作：
        //编写sql语句
        String sql = "insert into t_emp values(null,?,?,?)";
        //调用jdbc中的方法传递相关的参数,返回值是影响的行数
        //以下两种方式都可以：
        Object[] params={"林平之", 20, "未知"};
        int rows = jdbcTemplate.update(sql, params);

        //int rows = jdbcTemplate.update(sql, "东方不败", 20, "未知");
        System.out.println(rows);

         */

        //修改操作
//        String sql = "update t_emp set name=? where id=?";
//        int rows = jdbcTemplate.update(sql, "林平之atguigui", 3);
//        System.out.println(rows);

        //删除操作：
        String sql2 = "delete from t_emp where id=?";
        int row1 = jdbcTemplate.update(sql2, 3);
        System.out.println(row1);
    }

    @Test
    public void testQuery(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
    }
}
