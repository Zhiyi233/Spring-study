package com.atguigu.ioc.resource.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "myUserDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void addDao() {
        System.out.println("Dao.....");
    }
}
