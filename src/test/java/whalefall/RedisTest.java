package whalefall;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class RedisTest implements ApplicationContextAware {

    @Resource(name="redisCacheTemplate")// StringRedisTemplate
    private RedisTemplate<String, String> redisTemplate;

    private ApplicationContext context ;

    @Autowired
    private List<RedisTemplate> redisTemplateList;

    //    @Test
    public void test() {

        redisTemplate.opsForValue().set("name", "admin");
        Set<String> keys = showAllKeys();
        Assertions.assertTrue(!CollectionUtils.isEmpty(keys), "keys is empty");
        showAllKeys();
    }

    private Set<String> showAllKeys() {
        Set<String> keys = redisTemplate.keys("*");
        assert keys != null;
        keys.forEach(System.out::println);
        return keys;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
