package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.activity.dto.ActivityBriefInfo;
import cn.lsy99.api.activity.activity.dto.ActivityInfo;
import cn.lsy99.api.activity.activity.dto.AddActivityEntity;
import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.Category;
import cn.lsy99.api.activity.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    private static final String DIVIDER = "|";
    private static final String DIVIDER_REGEXP = "\\|";

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
        if(activityOptional.isPresent()){
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
}
