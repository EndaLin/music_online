import com.dgut.music_online.MusicOnlineApplication;
import com.dgut.music_online.domain.SongList;
import com.dgut.music_online.service.SongListManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MusicOnlineApplication.class})
public class SongListManagerServiceTest {
    private static Logger logger = LoggerFactory.getLogger(CloudMusicManagerServiceTest.class);

    @Autowired
    private SongListManagerService songListManagerService;

    @Test
    public void getAllSongList() {
        List<SongList> songLists = songListManagerService.getAllSongLists();
        for (SongList songList:songLists) {
            logger.info(songList.toString());
        }
    }

    @Test
    public void getSongListById() {
        SongList songList = songListManagerService.getSongListById(309390784);
        System.out.println(songList);
    }

    @Test
    public void getSongListByPages(){
        List<SongList> songLists = songListManagerService.getSongListByPages(0, 3);
        System.out.println(songLists);
    }

    @Test
    public void updateSongList(){
        SongList songList = new SongList();
        songList.setId(309390798);
        songList.setName("测试修改");
        songList.setDescription("测试描述");
        songListManagerService.updateSongList(songList);
    }

    @Test
    public void deleteSongListById(){
        songListManagerService.deleteSongListById(309390800);
    }
}
