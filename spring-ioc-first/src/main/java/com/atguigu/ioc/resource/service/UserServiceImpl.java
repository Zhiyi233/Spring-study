package com.atguigu.ioc.resource.service;

import org.springframework.stereotype.Service;
import com.atguigu.ioc.resource.dao.UserDao;

import javax.annotation.Resource;

@Service(value = "myUserServiceImpl")
public class UserServiceImpl implements UserService {

    //没有指定名称，用myUserDao属性名来找
    @Resource(name = "myUserDao")
    private UserDao myUserDao;

    @Override
    public void addService() {
        System.out.println("UserService...");
        myUserDao.addDao();
    }
}
