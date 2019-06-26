package com.dgut.music_online.controller;

import com.dgut.music_online.domain.Detail;
import com.dgut.music_online.domain.Song;
import com.dgut.music_online.service.SongManagerService;
import com.dgut.music_online.tool.FileOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@Api(tags = "对歌曲操作的相关接口")
public class SongManagerController {

    @Autowired
    private Detail detail;

    @Autowired
    private SongManagerService songManagerService;

    @Autowired
    private Song song;


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
    @PostMapping(value = "/musicManage/uploadSong")
    public Detail insertSong(@RequestParam("song") MultipartFile file) {
        String songName[] = file.getOriginalFilename().split("\\.");
        String relativePath = null;
        song.setType(songName[1]);
        song.setName(songName[0]);

        try {
           relativePath = FileOperator.fileUploud(file);
            song.setUrl("http://localhost:8080" + relativePath);
            songManagerService.insertSong(song);
        } catch (IOException e) {
            detail.setCode(500);
            detail.setMessage("歌曲上传出错");
        } catch (Exception e){
            detail.setCode(500);
            detail.setMessage("服务器错误");
        }finally {
            return detail;
        }
    }


    @ApiOperation("根据ID删除歌曲信息（后台）")
    @PostMapping(value = "/musicManage/deleteSongById")
    public Detail deleteSongById(@RequestParam("id")Integer id) {
        songManagerService.deleteSongById(id);
        return detail;
    }


    @ApiOperation("根据ID修改歌曲信息（后台）")
    @PutMapping(value = "/song/{id}")
    public Detail updateSongById(@PathVariable("id")Integer id) {
        return null;
    }

    @ApiOperation("分页显示歌曲（后台）")
    @GetMapping(value = "/musicManage/getSongsByPages")
    public Detail getSongsByPages(@RequestParam("pages") int pages) {
        List<Song> songs = songManagerService.getSongsByPages(pages);

        Map<Object, Object> map = new HashMap<>();
        map.put("songs", songs);
        detail.setDetail(map);
        return detail;
    }

}
