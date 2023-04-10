package com.atguigu.dao;

import com.atguigu.annotation.Bean;
import com.atguigu.annotation.Di;

/**
 * 手写ioc
 */
@Bean
public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("Dao...bean");
    }
}
