package com.dgut.music_online.dao;

import com.dgut.music_online.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/5/12 9:38
 */
@Mapper
@Component
public interface UserDao {

    @Select("select * from music_online.user")
    List<User> getAllUser();
}
