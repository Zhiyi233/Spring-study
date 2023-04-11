package com.atguigu.service;

import com.atguigu.annotation.Bean;
import com.atguigu.annotation.Di;
import com.atguigu.dao.UserDao;

@Bean
public class UserServiceImpl implements UserService{

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("Service....");
        userDao.add();
    }
}
