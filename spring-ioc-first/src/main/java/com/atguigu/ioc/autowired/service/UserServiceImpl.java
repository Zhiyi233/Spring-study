package com.atguigu.ioc.autowired.service;

import com.atguigu.ioc.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void addService() {
        System.out.println("UserService...");
        userDao.addDao();
    }
}
