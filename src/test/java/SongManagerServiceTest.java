import com.dgut.music_online.MusicOnlineApplication;
import com.dgut.music_online.domain.Song;
import com.dgut.music_online.service.SongManagerService;
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
public class SongManagerServiceTest {

    private static Logger logger = LoggerFactory.getLogger(SongManagerServiceTest.class);

    @Autowired
    private SongManagerService songManagerService;

    @Test
    public void getAllSongs() {
        List<Song> songList = songManagerService.getAllSongs();
        for (Song song:songList) {
            logger.info(song.toString());
        }
    }

    @Test
    public void getSong() {
        logger.info(songManagerService.getSongById(Integer.valueOf(252479)).toString());
    }

    @Test
    public void getSongsByPages(){
        List<Song> songs = songManagerService.getSongsByPages(0);
        for (Song song: songs){
            logger.info(song.toString());
        }
    }

    @Test
    public void deleteSongById(){
        songManagerService.deleteSongById(35504050);
    }
}
