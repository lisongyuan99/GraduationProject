package cn.lsy99.api.activity.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("visit")
public class VisitController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final String PREFIX = "visit.activity:";

    @PostMapping("visit")
    public void visit(@RequestBody int id) {
        String key = PREFIX+id;
        stringRedisTemplate.opsForValue().increment(key);
    }


}
