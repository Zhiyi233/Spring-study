package com.atguigu.ioc.xml.auto.service;

import com.atguigu.ioc.xml.auto.dao.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService的方法执行了");
        userDao.addUserDao();
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
    }
}
