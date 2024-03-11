package whalefall.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WhaleFall541
 * @Date: 2021/9/4 19:44
 */
@RestController
@Slf4j
public class RedisController {
    private static int cnt = 0;
    private static Object object = new Object();

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * http://localhost:8080/get?key=a
     */
    @RequestMapping("/get")
    public String get(String key) {
        Boolean flag = getValueOperations().setIfAbsent("lock", "lock");
        if (Boolean.FALSE.equals(flag)) {
            return "error";
        }

        try {
            cnt++;
            log.info("lock has gotten");
        } finally {
            redisTemplate.delete("lock");
        }
        return getValueOperations().get(key);
    }

    private ValueOperations<String, String> getValueOperations() {
        return redisTemplate.opsForValue();
    }

    /**
     * http://localhost:8080/put?key=a
     */
    @RequestMapping("/put")
    public void put(String key) {
        getValueOperations().set(key, key);
    }

}
