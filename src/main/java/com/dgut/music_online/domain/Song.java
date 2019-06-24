package com.dgut.music_online.domain;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Component;

@Component
@ApiModel("歌曲信息实体")
public class Song {
    /**
     * 歌曲ID
     */
    private Integer id;

    /**
     * 歌曲类型, mp3 ?
     */
    private String type;

    /**
     * 歌曲地址
     */
    private String url;

    /**
     * 歌曲名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
