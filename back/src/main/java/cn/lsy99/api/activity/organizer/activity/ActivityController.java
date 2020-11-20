package cn.lsy99.api.activity.organizer.activity;

import cn.lsy99.api.activity.organizer.activity.dto.ActivityWithToken;
import cn.lsy99.api.activity.organizer.table.Activity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("activity")
@Slf4j
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @PostMapping("add")
    public Activity add(@RequestBody ActivityWithToken input) {
        // TODO 权限管理
        log.info(input.toString());
        Activity result = activityService.add(input.getToken(), input.getActivity());
        return result;
    }
}
