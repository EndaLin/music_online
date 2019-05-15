package com.dgut.music_online.dao;

import com.dgut.music_online.domain.Song;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongDao {

    /**
     * 插入单条音乐的信息
     * @param song
     */
    void insertSong(Song song);
}
