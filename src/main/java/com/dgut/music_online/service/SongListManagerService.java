package com.dgut.music_online.service;

import com.dgut.music_online.domain.SongList;

import java.util.List;

public interface SongListManagerService {
    /**
     * 插入单条歌单信息
     */
    void insertSongList(SongList songList);

    /**
     * 录入新歌曲到歌单中
     */
    void insertSongIntoSongList(Integer songListId, Integer songId);

    /**
     * 获取所有歌单信息
     */
    List<SongList> getAllSongLists();

    /**
     * 根据歌单ID获取歌单信息
     */
    SongList getSongListById(Integer id);
}
