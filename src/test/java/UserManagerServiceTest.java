import com.dgut.music_online.MusicOnlineApplication;
import com.dgut.music_online.domain.User;
import com.dgut.music_online.service.UserManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/5/12 9:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MusicOnlineApplication.class})// 指定启动类
public class UserManagerServiceTest {

    @Autowired
    UserManagerService userManagerService;

    @Test
    public void test() {
        List<User> userList = userManagerService.getAllUser();
        System.out.println(userList.get(0).toString());
    }
}
