package com.atguigu.ioc.resource.dao;

import org.springframework.stereotype.Repository;

@Repository("myUserRedisDao")
public class UserRedisDaoImpl implements UserDao {

    @Override
    public void addDao() {
        System.out.println("RedisDao....");
    }
}
