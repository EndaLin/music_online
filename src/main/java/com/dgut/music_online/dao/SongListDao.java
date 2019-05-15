package com.dgut.music_online.dao;

import com.dgut.music_online.domain.SongList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongListDao {

    /**
     * 新增歌单
     */
    void insertSongList(SongList songList);
}
