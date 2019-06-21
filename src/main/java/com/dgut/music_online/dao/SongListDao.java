package com.dgut.music_online.dao;

import com.dgut.music_online.domain.SongList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 获取所有歌单的信息
     */
    List<SongList> getAllSongLists();

    /**
     * 根据歌单ID获取歌单信息
     */
    SongList getSongListById(Integer id);
}
