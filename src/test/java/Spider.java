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
        String url = "https://wt-git-repository.github.io/";
        for (int i = 0;i < 10000;i++) {
            restTemplate.getForObject(url, String.class);
            System.out.println("访问第" + i + "次");
        }
    }
}
