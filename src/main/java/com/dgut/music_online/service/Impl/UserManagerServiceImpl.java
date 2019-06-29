package com.dgut.music_online.service.Impl;

import com.dgut.music_online.dao.UserDao;
import com.dgut.music_online.domain.User;
import com.dgut.music_online.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/5/12 9:52
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private User userCheck;

    @Override
    public List<User> getAllUser() {
        System.out.println("enter");
        return userDao.getAllUser();
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public int loginManager(User user) {
        userCheck = userDao.getUserById(user.getId());
        if (userCheck == null){
            return 400;
        }else if (userCheck.getPassword().equals(user.getPassword())){
            return 200;
        }else {
            return 400;
        }
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUsersByPages(int pages) {

        return userDao.getUsersByPages((pages-1)*10, 30);
    }

    @Override
    public List<User> getPreManagesByPages(int pages) {
        return userDao.getPreManagesByPages((pages-1)*10, 30);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void registerManager(Integer id, boolean answer) {
        if (answer){
            userDao.registerToManager(id);
        }else{
            userDao.notRegisterToManager(id);
        }
    }

    @Override
    public void applyToManager(Integer id) {
        userDao.applyToManager(id);
    }

}
