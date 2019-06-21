package com.dgut.music_online.dao;

import com.dgut.music_online.domain.Song;
import org.apache.ibatis.annotations.Mapper;

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
}
