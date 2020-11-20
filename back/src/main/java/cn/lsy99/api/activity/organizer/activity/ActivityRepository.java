package cn.lsy99.api.activity.organizer.activity;

import cn.lsy99.api.activity.organizer.mapper.ActivityMapper;
import cn.lsy99.api.activity.organizer.table.Activity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ActivityRepository {
    @Resource
    ActivityMapper activityMapper;

    public int  addActivity(Activity activity) {
        return activityMapper.insertSelective(activity);
    }
}
