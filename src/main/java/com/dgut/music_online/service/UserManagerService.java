package com.dgut.music_online.service;

import com.dgut.music_online.dao.UserDao;
import com.dgut.music_online.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/5/12 9:52
 */
@Service
public class UserManagerService {

    @Autowired
    UserDao userDao;

    public List<User> getAllUser() {
        System.out.println("enter");
        return userDao.getAllUser();
    }

}
