package com.dgut.music_online.controller;

import com.dgut.music_online.domain.Detail;
import com.dgut.music_online.domain.Song;
import com.dgut.music_online.service.SongManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "对歌曲操作的相关接口")
public class SongManagerController {

    @Autowired
    private Detail detail;

    @Autowired
    private SongManagerService songManagerService;


    @ApiOperation("提取所有歌曲信息")
    @GetMapping(value = "/song")
    public Detail getAllSongs() {
        List<Song> songList = songManagerService.getAllSongs();
        Map<Object, Object> map = new HashMap<>();
        map.put("musics", songList);
        detail.setDetail(map);
        return detail;
    }


    @ApiOperation("根据ID提取歌曲信息")
    @GetMapping(value = "/song/{id}")
    public Detail getSongById(@PathVariable("id")Integer id) {
        Song song = songManagerService.getSongById(id);
        Map<Object, Object> map = new HashMap<>();
        map.put("musics", song);
        detail.setDetail(map);
        return detail;
    }


    @ApiOperation("插入单条歌曲的信息(后台)")
    @PostMapping(value = "/song")
    public Detail insertSong() {
        return null;
    }


    @ApiOperation("根据ID删除歌曲信息（后台）")
    @DeleteMapping(value = "/song/{id}")
    public Detail deleteSongById(@PathVariable("id")Integer id) {
        return null;
    }


    @ApiOperation("根据ID修改歌曲信息（后台）")
    @PutMapping(value = "/song/{id}")
    public Detail updateSongById(@PathVariable("id")Integer id) {
        return null;
    }
}
