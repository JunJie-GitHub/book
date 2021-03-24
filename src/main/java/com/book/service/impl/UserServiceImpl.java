package com.book.service.impl;

import com.book.dao.UserDao;
import com.book.dao.impl.UserDaoImpl;
import com.book.pojo.User;
import com.book.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    public void register(User user) {
        userDao.saveUser(user);
    }

    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    public User login(String username, String password) {
        return userDao.queryUserByUsernameAndPassword(username, password);
    }
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
