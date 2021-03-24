package com.book.service.impl;

import com.book.pojo.User;
import com.book.service.UserService;
import org.junit.Test;

class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    void register() {
        userService.register(new User(null, "tom", "abc5555", "425435434@163.com"));
    }

    @Test
    void login() {
        System.out.println(userService.login(new User(null, "admin", "mima456", null)));
    }

    @Test
    void existsUsername() {
        if (userService.existsUsername("admin")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户可用");
        }
    }
}