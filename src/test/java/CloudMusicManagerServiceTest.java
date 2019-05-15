
import com.dgut.music_online.MusicOnlineApplication;
import com.dgut.music_online.domain.SongList;
import com.dgut.music_online.service.CloudMusicManagerService;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 网易云API
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MusicOnlineApplication.class})
public class CloudMusicManagerServiceTest {

    private static Logger logger = LoggerFactory.getLogger(CloudMusicManagerServiceTest.class);

    @Autowired
    private CloudMusicManagerService cloudMusicManagerService;


    @Test
    public void getSongList() {
        String url = "https://api.imjad.cn/cloudmusic/?type=playlist&id=309390784";
        SongList songList = cloudMusicManagerService.getMessageFromSongList(url);
        cloudMusicManagerService.getMusicDetail(songList.getListSong());
        logger.info(songList.toString());
    }

    @Test
    public void getMusicDetail() {

    }
}
