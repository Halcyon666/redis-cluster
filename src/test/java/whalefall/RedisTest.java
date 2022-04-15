package whalefall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class RedisTest implements ApplicationContextAware {

    @Resource(name="redisCacheTemplate")// StringRedisTemplate
    private RedisTemplate<String, String> redisTemplate;

    private ApplicationContext context ;

    @Autowired
    private List<RedisTemplate> redisTemplateList;

    @Test
    public void test() {
//        redisTemplateList.forEach(ele -> System.err.println(ele));
//
//        redisTemplate.opsForValue().set("name", "admin");
//        String name = redisTemplate.opsForValue().get("name");
//        System.err.println(name); //输出admin
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}