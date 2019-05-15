package com.dgut.music_online.service;

import com.dgut.music_online.domain.User;

import java.util.List;

public interface UserManagerService {

    /**
     * 获取所有用户的信息
     */
    List<User> getAllUser();

    /**
     * 插入当条用户信息
     */
    void insertUser(User user);
}
