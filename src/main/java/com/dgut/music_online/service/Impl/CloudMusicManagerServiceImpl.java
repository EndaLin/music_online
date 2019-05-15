package com.dgut.music_online.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dgut.music_online.domain.Song;
import com.dgut.music_online.domain.SongList;
import com.dgut.music_online.domain.User;
import com.dgut.music_online.service.CloudMusicManagerService;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CloudMusicManagerServiceImpl implements CloudMusicManagerService {

    private static Logger logger = LoggerFactory.getLogger(CloudMusicManagerService.class);

    /**
     * 获取音乐detail的url
     */
    private static String URL = "https://api.imjad.cn/cloudmusic/?type=song&id={?}";


    private static RestTemplate restTemplate = new RestTemplate();

    @Override
    public SongList getMessageFromSongList(String url) {


        /**
         * all
         */
        JSONObject detail = restTemplate.getForObject(url, JSONObject.class);
        logger.info(detail.toJSONString());

        /**
         * playlist 封装歌单以及创建者信息
         */
        JSONObject playList = detail.getJSONObject("playlist");
        JSONObject creator = playList.getJSONObject("creator");
        String coverImgUrl = playList.getString("coverImgUrl");
        String description = playList.getString("description");
        String name = playList.getString("name");
        User user = new User();
        user.setId(creator.getInteger("userId"));
        user.setNickname(creator.getString("nickname"));
        user.setGender(creator.getInteger("gender"));
        user.setSignature(creator.getString("signature"));
        user.setAvatarUrl(creator.getString("avatarUrl"));
        user.setUserType(0);
        SongList songList = new SongList();
        songList.setId(playList.getInteger("id"));
        songList.setName(name);
        songList.setCoverImgUrl(coverImgUrl);
        songList.setDescription(description);
        songList.setCreatorId(user.getId());

        /**
         * privileges 封装歌单下面每一首歌的ID
         */
        List<Song> songs = new ArrayList<>();
        JSONArray jsonArray = detail.getJSONArray("privileges");
        for (Object object : jsonArray) {
            Song song = new Song();
            song.setId(((JSONObject) object).getInteger("id"));
            songs.add(song);
        }
        songList.setListSong(songs);
        return songList;
    }

    @Override
    public void getMusicDetail(List<Song> songs) {
        for (Song song : songs) {
            Integer id = song.getId();
            JSONObject jsonObject = restTemplate.getForObject(URL, JSONObject.class, id);
            JSONObject data = (JSONObject) jsonObject.getJSONArray("data").get(0);
            song.setType(data.getString("type"));
            song.setUrl(data.getString("url"));
        }
    }
}
