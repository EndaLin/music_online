package com.dgut.music_online.domain;

import org.springframework.stereotype.Component;

@Component
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
                '}';
    }
}
