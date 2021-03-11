package cn.lsy99.api.activity.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class TestControllerTest {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        String key = "phone.verify:" + "13812345678";
        stringRedisTemplate.opsForValue().set(key, "123456", 1, TimeUnit.MINUTES);
    }

    @Test
    public void test2() {
        String key = "phone.verify:" + "13812345678";
        String value = stringRedisTemplate.opsForValue().get(key);
        System.out.println(value);
    }
}