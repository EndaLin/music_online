package com.dgut.music_online.service;

import com.dgut.music_online.domain.User;
import io.swagger.models.auth.In;

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

    /**
     * 用户登陆管理
     * @param user 包含即将登陆的用户信息
     * @return 返回int类型的状态码 200：登陆成功，400：密码错误或已经登陆
     */
    int loginManager(User user);

    /**
     * 通过用户id 获取用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 通过当前页数获取一页用户数据
     * @param pages
     * @return
     */
    List<User> getUsersByPages(int pages);

    /**
     * 通过当前页数获取一页申请为管理员的普通用户数据
     * @param pages
     * @return
     */
    List<User> getPreManagesByPages(int pages);

    /**
     * 根据用户id 删除用户
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * 审批用户是否成为管理员
     * @param id
     * @param answer true 表示同意 false 表示不同意
     */
    void registerManager(Integer id, boolean answer);

    /**
     * 申请成为管理员
     * @param id
     */
    void applyToManager(Integer id);
}
