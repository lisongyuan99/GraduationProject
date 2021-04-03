package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.activity.dto.ActivityBriefInfo;
import cn.lsy99.api.activity.activity.dto.ActivityInfo;
import cn.lsy99.api.activity.activity.dto.AddActivityEntity;
import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.ActivityStatistics;
import cn.lsy99.api.activity.generator.table.Category;
import cn.lsy99.api.activity.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    private static final String ACTIVITY_PREFIX = "visit.activity:";
    private static final String USER_PREFIX = "visit.user:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public List<Category> getAllCategory() {
        return activityRepository.getAllCategory();
    }

    public int addActivity(int id, AddActivityEntity addActivityEntity) {
        String pics = ArrayUtil.StringArrayToString(addActivityEntity.getPictures());
        Activity activity = Activity.builder()
                .organizerId(id)
                .title(addActivityEntity.getName())
                .subtitle(addActivityEntity.getIntroduction())
                .detail(addActivityEntity.getDetail())
                .beginTime(addActivityEntity.getDate())
                .category(addActivityEntity.getCategory())
                .positionCode(addActivityEntity.getRegionCode())
                .positionDetail(addActivityEntity.getAddress())
                .pics(pics)
                .build();
        return activityRepository.addActivity(activity);
    }

    public List<ActivityBriefInfo> getMyActivity(int id) {
        List<Activity> activities = activityRepository.getMyActivity(id);
        List<ActivityBriefInfo> result = new ArrayList<>();
        for (Activity activity : activities) {
            String[] pics = ArrayUtil.StringToStringArray(activity.getPics());
            String pic = null;
            if (pics.length > 0) {
                pic = pics[0];
            }
            ActivityBriefInfo temp = ActivityBriefInfo.builder()
                    .id(activity.getId())
                    .pic(pic)
                    .name(activity.getTitle())
                    .date(activity.getBeginTime())
                    .regionCode(activity.getPositionCode())
                    .build();
            result.add(temp);
        }
        return result;
    }

    public ActivityInfo getById(int id) {
        Optional<Activity> activityOptional = activityRepository.getById(id);
        if (activityOptional.isPresent()) {
            Activity activity = activityOptional.get();
            return ActivityInfo.builder()
                    .id(activity.getId())
                    .pics(ArrayUtil.StringToStringArray(activity.getPics()))
                    .name(activity.getTitle())
                    .description(activity.getSubtitle())
                    .time(activity.getBeginTime())
                    .regionCode(activity.getPositionCode())
                    .address(activity.getPositionDetail())
                    .detail(activity.getDetail())
                    .build();
        } else {
            // TODO 异常处理
            return null;
        }
    }

    @Transactional
    public int statistic(int limit) {
        List<Activity> result = activityRepository.getActivitiesId(limit);
        if (result.size() == 0) {
            return -1;
        } else {
            for (Activity e : result) {
                String countString = stringRedisTemplate.opsForValue().get(ACTIVITY_PREFIX + e.getId());
                int count = 0;
                if (countString != null) {
                    count = Integer.parseInt(countString);
                }
                activityRepository.insertActivityCount(e.getId(), e.getOrganizerId(), count);
                stringRedisTemplate.delete(ACTIVITY_PREFIX + e.getId());
            }
            return result.get(result.size()-1).getId();
        }
    }

    @Transactional
    public int statistic(int lastId, int limit) {
        List<Activity> result = activityRepository.getActivitiesId(lastId, limit);
        if (result.size() == 0) {
            return -1;
        } else {
            for (Activity e : result) {
                String countString = stringRedisTemplate.opsForValue().get(ACTIVITY_PREFIX + e.getId());
                int count = 0;
                if (countString != null) {
                    count = Integer.parseInt(countString);
                }
                activityRepository.insertActivityCount(e.getId(), e.getOrganizerId(), count);
                stringRedisTemplate.delete(ACTIVITY_PREFIX + e.getId());
            }
            return result.get(result.size()-1).getId();
        }
    }

    public List<ActivityStatistics>  test(){
        return activityRepository.test();
    }
}
