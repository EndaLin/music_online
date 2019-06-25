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

    /**
     * 根据页数获取分页歌单
     * @param pages 当前获取的第几页歌单数据
     * @param number 每一页包含的歌单数量
     */
    List<SongList> getSongListByPages(int pages, int number);

    /**
     * 更新歌单，更新歌单的名称，和描述信息
     * @param songList 包含更新的信息，name 将要替换的歌单名称， description 将要替换的描述信息， id 唯一匹配歌单的凭据
     */
    void updateSongList(@Param("songList") SongList songList);

    /**
     * 根据歌单id 删除歌单
     * @param id 唯一匹配歌单的凭据
     */
    void deleteSongListById(@Param("id") Integer id);
}
