package com.dgut.music_online.controller;

import com.dgut.music_online.domain.Detail;
import com.dgut.music_online.domain.SongList;
import com.dgut.music_online.service.SongListManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "对歌单操作的相关接口")
public class SongListManagerController {

    @Autowired
    private Detail detail;

    @Autowired
    private SongListManagerService songListManagerService;

    @ApiOperation("获取所有歌单信息")
    @GetMapping(value = "/songList")
    public Detail getAllSongLists() {
        List<SongList> songLists = songListManagerService.getAllSongLists();
        Map<Object, Object> map = new HashMap<>();
        map.put("songLists", songLists);
        detail.setDetail(map);
        return detail;
    }

    @ApiOperation("根据歌单ID获取歌单信息")
    @GetMapping(value = "/songList/{id}")
    public Detail getSongListById(@PathVariable("id")Integer id) {
        SongList songList = songListManagerService.getSongListById(id);
        Map<Object, Object> map = new HashMap<>();
        map.put("songList", songList);
        detail.setDetail(map);
        return detail;
    }

    @ApiOperation("创建歌单")
    @PostMapping(value = "songList")
    public Detail insertSongList() {
        return null;
    }

    @ApiOperation("根据歌单ID修改歌单信息")
    @PutMapping(value = "/songList/{id}")
    public Detail updateSongList(@PathVariable("id")Integer id) {
        return null;
    }

    @ApiOperation("根据歌单ID删除歌单")
    @DeleteMapping(value = "/songList/{id}")
    public Detail deleteSongListById(@PathVariable("id")Integer id) {
        return null;
    }
}
