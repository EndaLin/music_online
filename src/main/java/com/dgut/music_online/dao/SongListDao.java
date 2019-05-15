package com.dgut.music_online.dao;

import com.dgut.music_online.domain.SongList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SongListDao {

    /**
     * 新增歌单
     */
    void insertSongList(SongList songList, @Param("creatorId") Integer creatorId);

    /**
     * 录入新歌到歌单中
     */
    void insertSongIntoSongList(@Param("songListId") Integer songListId,@Param("songId") Integer songId);
}
