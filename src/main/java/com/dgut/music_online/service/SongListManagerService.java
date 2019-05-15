package com.dgut.music_online.service;

import com.dgut.music_online.domain.SongList;

public interface SongListManagerService {
    /**
     * 插入单条歌单信息
     */
    void insertSongList(SongList songList);

    /**
     * 录入新歌曲到歌单中
     */
    void insertSongIntoSongList(Integer songListId, Integer songId);
}
