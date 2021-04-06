package cn.lsy99.api.activity.visit;

import cn.lsy99.api.activity.generator.table.ActivityStatistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("visit")
@Slf4j
public class VisitController {

    @Autowired
    private VisitService visitService;
    private static final int LIMIT = 2;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final String PREFIX = "visit.activity:";

    @PostMapping("visit")
    public void visit(@RequestBody int id) {
        String key = PREFIX+id;
        stringRedisTemplate.opsForValue().increment(key);
    }

    @GetMapping("statistic")
    public void statistic(){
        int result = visitService.statistic(LIMIT);
        while (result != -1) {
            result = visitService.statistic(result, LIMIT);
            // List<ActivityStatistics> temp = visitService.test();
            // log.info(temp.toString());
        }
    }


}
