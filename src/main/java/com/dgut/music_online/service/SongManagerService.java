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

    /**
     * 获取所有歌曲信息
     */
    List<Song> getAllSongs();

    /**
     * 根据歌曲ID获取歌曲信息
     */
    Song getSongById(Integer id);

    /**
     * 通过页数获取一页歌曲
     * @param pages 页数，一页30 条数据
     * @return 一个链表歌曲
     */
    List<Song> getSongsByPages(int pages);

    /**
     * 根据歌曲id 删除歌曲
     * @param id 匹配歌曲的唯一标识符
     */
    void deleteSongById(Integer id);
}
