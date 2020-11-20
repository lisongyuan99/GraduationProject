package cn.lsy99.api.activity.organizer.activity;

import cn.lsy99.api.activity.organizer.table.Activity;
import cn.lsy99.api.activity.organizer.auth.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ActivityService {
    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    ActivityRepository activityRepository;

    public Activity add(String token, Activity activity){
        // TODO 异常处理
        log.info(jwtUtil.toString());
        int id = jwtUtil.getUserIdFromToken(token);
        Date now = new Date();
        activity.setCreateTime(now);
        activity.setUpdateTime(now);
        activity.setOrganizerId(id);
        activityRepository.addActivity(activity);
        return activity;
    }
}
