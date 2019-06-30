package com.dgut.music_online.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.dgut.music_online.dao.SongListDao;
import com.dgut.music_online.domain.SongList;
import com.dgut.music_online.service.SongListManagerService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SongListManagerServiceImpl implements SongListManagerService {

    @Autowired
    SongListDao songListDao;

    @Override
    public void insertSongList(SongList songList) {
        songListDao.insertSongList(songList, songList.getCreatorId());
    }

    @Override
    public void insertSongIntoSongList(Integer songListId, Integer[] songId) {

        for (int i = 0; i < songId.length; i++) {
            songListDao.insertSongIntoSongList(songListId, songId[i]);
        }
    }

    @Override
    public List<SongList> getAllSongLists() {
        return songListDao.getAllSongLists();
    }

    @Override
    public SongList getSongListById(Integer id) {
        SongList songList = songListDao.getSongListById(id);
        return songList;
    }

    @Override
    public List<SongList> getSongListByPages(int pages, int limit) {
        List<SongList> songLists = songListDao.getSongListByPages((pages - 1) * 10, limit);
        return songLists;
    }

    @Override
    public void updateSongList(SongList songList) {
        songListDao.updateSongList(songList);
    }

    @Override
    public void deleteSongListById(Integer id) {
        songListDao.deleteSongListById(id);
    }
}
