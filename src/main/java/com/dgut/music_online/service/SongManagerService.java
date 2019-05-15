package com.dgut.music_online.service;

import com.dgut.music_online.domain.Song;

import java.util.List;

public interface SongManagerService {
    /**
     * 插入单条歌曲信息
     */
    void insertSong(Song song);

    /**
     * 批量插入歌曲信息
     */
    void insertSongsInBulk(List<Song> songs);
}
