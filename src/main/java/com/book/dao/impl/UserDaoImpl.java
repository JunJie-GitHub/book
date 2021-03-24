package com.book.dao.impl;

import com.book.dao.UserDao;
import com.book.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    public User queryUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return queryForOne(User.class, sql, username);
    }

    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    public int saveUser(User user) {
        String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
        return update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getEmail());

    }
}
