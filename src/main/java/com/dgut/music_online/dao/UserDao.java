package com.dgut.music_online.dao;

import com.dgut.music_online.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
}
