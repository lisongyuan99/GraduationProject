package cn.lsy99.api.activity.visit;

import cn.lsy99.api.activity.activity.ActivityRepository;
import cn.lsy99.api.activity.generator.table.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitService {

    @Autowired
    VisitRepository visitRepository;
    private static final String ACTIVITY_PREFIX = "visit.activity:";
    private static final String USER_PREFIX = "visit.user:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Transactional
    public int statistic(int limit) {
        List<Activity> result = visitRepository.getActivitiesId(limit);
        if (result.size() == 0) {
            return -1;
        } else {
            for (Activity e : result) {
                String countString = stringRedisTemplate.opsForValue().get(ACTIVITY_PREFIX + e.getId());
                int count = 0;
                if (countString != null) {
                    count = Integer.parseInt(countString);
                }
                visitRepository.insertActivityCount(e.getId(), e.getOrganizerId(), count);
                // stringRedisTemplate.delete(ACTIVITY_PREFIX + e.getId());
            }
            return result.get(result.size()-1).getId();
        }
    }

    // TODO 需要改进
    @Transactional
    public int statistic(int lastId, int limit) {
        List<Activity> result = visitRepository.getActivitiesId(lastId, limit);
        if (result.size() == 0) {
            return -1;
        } else {
            for (Activity e : result) {
                String countString = stringRedisTemplate.opsForValue().get(ACTIVITY_PREFIX + e.getId());
                int count = 0;
                if (countString != null) {
                    count = Integer.parseInt(countString);
                }
                visitRepository.insertActivityCount(e.getId(), e.getOrganizerId(), count);
                // stringRedisTemplate.delete(ACTIVITY_PREFIX + e.getId());
            }
            return result.get(result.size()-1).getId();
        }
    }
}
