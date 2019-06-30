import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Spider.class})
public class Spider {

    private static RestTemplate restTemplate = new RestTemplate();

    @Test
    public void run() {
        System.out.println(System.currentTimeMillis() / 10000);
    }
}
