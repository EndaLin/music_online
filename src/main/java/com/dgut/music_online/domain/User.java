package com.dgut.music_online.domain;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/5/12 9:38
 */
@Component
@ApiModel("用户信息实体")
public class User {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String nickname;

    /**
     * 用户头像地址
     */
    private String avatarUrl;

    /**
     * 签名
     */
    private String signature;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 该用户创建的歌单信息
     * @return
     */
    private List<SongList> songLists = new ArrayList<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public List<SongList> getSongLists() {
        return songLists;
    }

    public void setSongLists(List<SongList> songLists) {
        this.songLists = songLists;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", signature='" + signature + '\'' +
                ", gender=" + gender +
                ", userType=" + userType +
                '}';
    }
}
