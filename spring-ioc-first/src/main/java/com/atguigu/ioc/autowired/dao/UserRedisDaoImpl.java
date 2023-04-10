package com.atguigu.ioc.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDaoImpl implements UserDao{

    @Override
    public void addDao() {
        System.out.println("RedisDao....");
    }
}
