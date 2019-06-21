package com.dgut.music_online.service.Impl;

import com.dgut.music_online.dao.SongDao;
import com.dgut.music_online.domain.Song;
import com.dgut.music_online.service.SongManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongManagerServiceImpl implements SongManagerService {

    @Autowired
    SongDao songDao;

    @Override
    public void insertSong(Song song) {
        songDao.insertSong(song);
    }

    @Override
    public void insertSongsInBulk(List<Song> songs) {
        for (Song song: songs) {
            songDao.insertSong(song);
        }
    }

    @Override
    public List<Song> getAllSongs() {
        return songDao.getAllSongs();
    }

    @Override
    public Song getSongById(Integer id) {
        return songDao.getSongById(id);
    }
}
