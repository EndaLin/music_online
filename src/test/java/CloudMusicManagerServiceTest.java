import com.dgut.music_online.MusicOnlineApplication;
import com.dgut.music_online.domain.Song;
import com.dgut.music_online.domain.SongList;
import com.dgut.music_online.domain.User;
import com.dgut.music_online.service.CloudMusicManagerService;
import com.dgut.music_online.service.SongListManagerService;
import com.dgut.music_online.service.SongManagerService;
import com.dgut.music_online.service.UserManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * 网易云API
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MusicOnlineApplication.class})
public class CloudMusicManagerServiceTest {

    private static Logger logger = LoggerFactory.getLogger(CloudMusicManagerServiceTest.class);

    @Autowired
    private CloudMusicManagerService cloudMusicManagerService;

    @Autowired
    private SongListManagerService songListManagerService;

    @Autowired
    private SongManagerService songManagerService;

    @Autowired
    private UserManagerService userManagerService;

    @Test
    public void getSongList() {
        /**
         * 获取
         */
        String url = "https://api.imjad.cn/cloudmusic/?type=playlist&id=309390784";
        SongList songList = cloudMusicManagerService.getMessageFromSongList(url);
        if (songList == null) {
            return;
        }
        cloudMusicManagerService.getMusicDetail(songList.getListSong());
        logger.info(songList.toString());

        /**
         * 插入到数据库中
         */
        // 录入新歌单的信息
        songListManagerService.insertSongList(songList);
        List<Song> songs = songList.getListSong();
        for (Song song : songs) {
            // 插入新歌
            songManagerService.insertSong(song);
        }
        // 将每首新歌与歌单关联
        songListManagerService.insertSongIntoSongList(songList.getId(), (Integer[]) songs.toArray());


        User user = songList.getUser();
        userManagerService.insertUser(user);
        logger.info("录入完成");
    }

    @Test
    public void getMusicDetail() {

    }
}
