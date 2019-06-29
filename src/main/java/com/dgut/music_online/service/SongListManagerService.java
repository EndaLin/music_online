package com.dgut.music_online.service;

import com.dgut.music_online.domain.SongList;
import io.swagger.models.auth.In;

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

    /**
     *根据页数获取歌单页，一次30条
     */
    List<SongList> getSongListByPages(int pages, int limit);

    /**
     * 更新歌单，更新歌单的名称，和描述信息
     * @param songList 包含更新的信息，name 将要替换的歌单名称， description 将要替换的描述信息， id 唯一匹配歌单的凭据
     */
    void updateSongList(SongList songList);

    /**
     * 根据id 删除歌单
     * @param id 匹配歌单的唯一标识
     */
    void deleteSongListById(Integer id);
}
