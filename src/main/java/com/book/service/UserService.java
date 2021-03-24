package com.book.service;

import com.book.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    void register(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);
    User login(String username, String password);
    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在, 返回false表示用户名可用
     */
    boolean existsUsername(String username);
}
