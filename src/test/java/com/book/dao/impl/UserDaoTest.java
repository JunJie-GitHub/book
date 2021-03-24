package com.book.dao.impl;

import com.book.dao.UserDao;
import com.book.pojo.User;
import org.junit.Test;

class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在!");
        }
    }

    @Test
    void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误, 登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null, "jerry", "34865555","tomvat@gmail.com")));
    }
}