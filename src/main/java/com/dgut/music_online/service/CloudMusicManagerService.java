package com.dgut.music_online.service;

import com.dgut.music_online.domain.Song;
import com.dgut.music_online.domain.SongList;

import java.util.List;

/**
 * 网易云音乐源API接口
 */
public interface CloudMusicManagerService {
    /**
     * API 示例： https://api.imjad.cn/cloudmusic/?type=playlist&id=309390784
     * 获取歌单的相关信息
     */
    SongList getMessageFromSongList(String url);

    /**
     * API 示例：https://api.imjad.cn/cloudmusic/?type=song&id=28012031&br=128000
     * 根据音乐ID,批量获取歌曲的相关信息
     */
    void getMusicDetail(List<Song> songs);
}
