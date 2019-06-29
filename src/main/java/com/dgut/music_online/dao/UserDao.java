package com.dgut.music_online.dao;

import com.dgut.music_online.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/5/12 9:38
 */
@Mapper
public interface UserDao {

    /**
     * 获取所有的用户信息
     * @return
     */
    List<User> getAllUser();


    /**
     * 新增用户
     */
    void insertUser(User user);

    /**
     * 通过用户id 获取用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    User getUserByIdManager(Integer id);

    /**
     * 分页获取用户数据
     * @param pages
     * @param number
     * @return
     */
    List<User> getUsersByPages(@Param("pages")int pages, @Param("number") int number);

    /**
     * 分页获取申请管理员的用户数据
     * @param pages
     * @param number
     * @return
     */
    List<User> getPreManagesByPages(@Param("pages")int pages, @Param("number") int number);

    void deleteUserById(Integer id);



    /**
     * 申请成为管理员
     * @param id
     */
    void applyToManager(Integer id);

    /**
     * 同意注册为管理员
     * @param id
     */
    void registerToManager(Integer id);

    /**
     * 不同意注册为管理员
     * @param id
     */
    void notRegisterToManager(Integer id);
}
