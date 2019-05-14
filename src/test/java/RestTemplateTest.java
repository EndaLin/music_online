import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateTest {

    @Test
    public void test() {
        String url = "https://api.imjad.cn/cloudmusic/?type=search&search_type=1002&s=CeuiLiSA";
        RestTemplate restTemplate = new RestTemplate();
        Map map = restTemplate.getForObject(url, Map.class);
        System.out.println(map.toString());
    }

    @Test
    public void Insert() {

    }
}
