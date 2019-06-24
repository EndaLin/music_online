package com.dgut.music_online.dao;

import com.dgut.music_online.domain.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SongDao {

    /**
     * 插入单条音乐的信息
     * @param song
     */
    void insertSong(Song song);

    /**
     * 提取所有歌曲的信息
     */
    List<Song> getAllSongs();

    /**
     * 根据ID获取歌曲信息
     */
    Song getSongById(Integer id);

    /**
     * 获取当前页数歌曲
     * @param pages 当前页数
     * @param number 一页歌曲的数量
     * @return 一页歌曲List
     */
    List<Song> getSongsByPages(@Param("pages") int pages,@Param("number") int number);

    /**
     * 根据歌曲id 删除歌曲
     * @param id 匹配歌曲的唯一标识符
     */
    void deleteSongById(@Param("id") Integer id);
}
