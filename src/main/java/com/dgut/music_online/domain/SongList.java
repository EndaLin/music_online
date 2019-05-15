package com.dgut.music_online.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SongList {
    /**
     * 歌单ID
     */
    private Integer id;

    /**
     * 创建者ID
     */
    private Integer creatorId;

    /**
     * 创建者信息
     */
    private User user;

    /**
     * 歌单描述
     */
    private String description;

    /**
     * 歌单名称
     */
    private String name;

    /**
     * 歌单封面图片地址
     */
    private String coverImgUrl;

    /**
     * 歌单下面所有歌曲的相关信息
     */
    private List<Song> listSong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public List<Song> getListSong() {
        return listSong;
    }

    public void setListSong(List<Song> listSong) {
        this.listSong = listSong;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public String toString() {
        return "SongList{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                ", listSong=" + listSong.toString() +
                '}';
    }
}
