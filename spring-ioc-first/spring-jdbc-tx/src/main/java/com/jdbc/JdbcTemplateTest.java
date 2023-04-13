package com.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);


        //添加操作：
        //编写sql语句
        String sql = "insert into t_emp values(null,?,?,?)";
        //调用jdbc中的方法传递相关的参数,返回值是影响的行数
        //以下两种方式都可以：
        Object[] params={"令狐冲", 20, "男"};
        int rows = jdbcTemplate.update(sql, params);

        //int rows = jdbcTemplate.update(sql, "东方不败", 20, "未知");
        System.out.println(rows);



        //修改操作
//        String sql = "update t_emp set name=? where id=?";
//        int rows = jdbcTemplate.update(sql, "林平之atguigui", 3);
//        System.out.println(rows);

        //删除操作：
//        String sql2 = "delete from t_emp where id=?";
//        int row1 = jdbcTemplate.update(sql2, 3);
//        System.out.println(row1);
    }

    @Test
    //返回对象
    public void testQuery(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        //写法一：自己封装
//        String sql = "select * from t_emp where id=?";
//        Emp empResult = jdbcTemplate.queryForObject(sql,
//                (rs, rowNum) -> {
//                    Emp emp = new Emp();
//                    emp.setName(rs.getString("name"));
//                    emp.setAge(rs.getInt("age"));
//                    emp.setId(rs.getInt("id"));
//                    emp.setSex(rs.getString("sex"));
//                    return emp;
//                }, 1);
//        System.out.println(empResult);

        //写法二
        String sql = "select * from t_emp where id=?";
        Emp empResult = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class),1);
        System.out.println(empResult);
    }

    @Test
    public void testSelectList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String sql = "select * from t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }
    @Test
    public void testSelectSingleValue(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String sql = "select count(*) from t_emp";
        //和返回对象一样用queryForObject但是里面的参数是返回类型的class
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}