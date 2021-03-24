package com.book.dao;

import com.book.pojo.User;

public interface UserDao {
    /**
     *根据用户名查询信息
     * @param username 用户名
     * @return 如果返回null, 没有这个用户
     */
    User queryUserByUsername(String username);
    /**
     *根据用户名和密码查询信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null, 用户名或密码错误
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int saveUser(User user);

}
