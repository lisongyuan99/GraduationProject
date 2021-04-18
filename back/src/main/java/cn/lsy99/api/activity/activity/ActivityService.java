package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.activity.dto.ActivityBriefInfo;
import cn.lsy99.api.activity.activity.dto.ActivityInfo;
import cn.lsy99.api.activity.activity.dto.ActivityModifyEntity;
import cn.lsy99.api.activity.activity.dto.CustomerInfo;
import cn.lsy99.api.activity.generator.table.*;
import cn.lsy99.api.activity.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Category> getAllCategory() {
        return activityRepository.getAllCategory();
    }

    @Transactional
    // 添加活动
    public int addActivity(int id, ActivityModifyEntity activityModifyEntity) {
        String pics = ArrayUtil.StringArrayToString(activityModifyEntity.getPictures());
        Activity activity = Activity.builder()
                .organizerId(id)
                .title(activityModifyEntity.getName())
                .subtitle(activityModifyEntity.getIntroduction())
                .detail(activityModifyEntity.getDetail())
                .beginTime(activityModifyEntity.getDate())
                .categoryId(activityModifyEntity.getCategory())
                .positionCode(activityModifyEntity.getRegionCode())
                // .positionDetail(activityModifyEntity.getAddress())
                .pics(pics)
                .free(activityModifyEntity.isFree())
                .sum(activityModifyEntity.getCount())
                .status(0)
                // .price(activityModifyEntity.getPrice())
                // .priceOri(activityModifyEntity.getOri())
                .build();
        if (activityModifyEntity.getRegionCode() != 0) {
            activity.setPositionDetail(activityModifyEntity.getAddress());
            activity.setPosLat(activityModifyEntity.getLat());
            activity.setPosLng(activityModifyEntity.getLng());
        }
        if(!activityModifyEntity.isFree()){
            activity.setPrice(activityModifyEntity.getPrice());
            activity.setPriceOri(activityModifyEntity.getOri());
        }
        int result = activityRepository.addActivity(activity);
        log.info(activity.toString());
        int activityId = activity.getId();
        int result1 = activityRepository.initCount(activityId, activityModifyEntity.getCount());
        int result3 = activityRepository.initStatistics(activityId, id);
        return activityId;
    }

    // @Transactional
    // TODO 优化
    // 获取我的活动
    public List<ActivityBriefInfo> getMyActivity(int id) {
        List<Activity> activities = activityRepository.getMyActivity(id);
        List<ActivityBriefInfo> result = new ArrayList<>();
        for (Activity activity : activities) {
            String[] pics = ArrayUtil.StringToStringArray(activity.getPics());
            String pic = null;
            if (pics.length > 0) {
                pic = pics[0];
            }
            int count = 0;
            Optional<ActivityCount>  countOptional = activityRepository.getCount(activity.getId());
            if (countOptional.isPresent()) {
                count = countOptional.get().getCount();
            }
            ActivityBriefInfo temp = ActivityBriefInfo.builder()
                    .id(activity.getId())
                    .pic(pic)
                    .name(activity.getTitle())
                    .date(activity.getBeginTime())
                    .regionCode(activity.getPositionCode())
                    .free(activity.getFree())
                    .category(activity.getCategoryId())
                    .price(activity.getPrice())
                    .ori(activity.getPriceOri())
                    .count(count)
                    .build();
            result.add(temp);
        }
        return result;
    }

    // 获取活动详细信息
    public ActivityInfo getById(int id) {
        Optional<Activity> activityOptional = activityRepository.getById(id);
        if (activityOptional.isPresent()) {
            long followUserNum = activityRepository.getFollowUserNum(id);
            long joinUserNum = activityRepository.getJoinUserNum(id);
            int viewUserNum = activityRepository.getViewNum(id);
            Activity activity = activityOptional.get();
            Optional<Organizer> organizer = activityRepository.getOrganizer(activityOptional.get().getOrganizerId());
            long upVote = activityRepository.getUpVoteNum(id);
            long downVote = activityRepository.getDownVoteNum(id);
            ActivityInfo result =  ActivityInfo.builder()
                    .id(activity.getId())
                    .pics(ArrayUtil.StringToStringArray(activity.getPics()))
                    .name(activity.getTitle())
                    .description(activity.getSubtitle())
                    .time(activity.getBeginTime())
                    .description(activity.getSubtitle())
                    .detail(activity.getDetail())

                    .regionCode(activity.getPositionCode())
                    .address(activity.getPositionDetail())
                    .lat(activity.getPosLat())
                    .lng(activity.getPosLng())

                    .followUserNum(followUserNum)
                    .viewUserNum(viewUserNum)
                    .joinUserNum(joinUserNum)
                    .up(upVote)
                    .down(downVote)
                    .rest(activity.getSum()-joinUserNum)

                    .free(activity.getFree())
                    .price(activity.getPrice())
                    .ori(activity.getPriceOri())
                    .build();
            if(organizer.isPresent()){
                result.setOrgAvatar(organizer.get().getAvatar());
                result.setOrgId(organizer.get().getId());
                result.setOrgMotto(organizer.get().getMotto());
                result.setOrgName(organizer.get().getNickname());
            }

            return result;
        } else {
            // TODO 异常处理
            return null;
        }
    }

    public List<CustomerInfo> getUser(int id) {
        List<Customer> users = activityRepository.getUser(id);
        List<CustomerInfo> result = new ArrayList<>();
        for (Customer user : users) {
            result.add(CustomerInfo.builder()
                    .id(user.getId())
                    .avatar(user.getAvatar())
                    .name(user.getNickname())
                    .motto(user.getMotto())
                    .build());
        }
        return result;
    }

    public int removeUser(int activityId, int userId) {
        return activityRepository.removeUser(activityId, userId);
    }

    public ActivityModifyEntity getByIdForEdit(int id) {
        Optional<Activity> activityOptional = activityRepository.getById(id);
        if (activityOptional.isPresent()) {
            Activity activity = activityOptional.get();
            return ActivityModifyEntity.builder()
                    .activityId(activity.getId())
                    .pictures(ArrayUtil.StringToStringArray(activity.getPics()))
                    .name(activity.getTitle())
                    .introduction(activity.getSubtitle())
                    .date(activity.getBeginTime())
                    .category(activity.getCategoryId())
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
    public int editActivity(int orgId, ActivityModifyEntity activityModifyEntity) {
        int activityId = activityModifyEntity.getActivityId();
        log.info(activityModifyEntity.toString());
        Optional<Activity> origin = activityRepository.getById(activityId);
        if (origin.isPresent()) {
            if (origin.get().getOrganizerId() == orgId) {
                String pics = ArrayUtil.StringArrayToString(activityModifyEntity.getPictures());
                return activityRepository.editActivity(Activity.builder()
                        .id(activityId)
                        .organizerId(orgId)
                        .title(activityModifyEntity.getName())
                        .subtitle(activityModifyEntity.getIntroduction())
                        .detail(activityModifyEntity.getDetail())
                        .beginTime(activityModifyEntity.getDate())
                        .categoryId(activityModifyEntity.getCategory())
                        .positionCode(activityModifyEntity.getRegionCode())
                        .positionDetail(activityModifyEntity.getAddress())
                        .pics(pics)
                        .build());
            }
        }
        return -1;
    }

    @Transactional
    public int deleteActivity(int orgId, int id) {
        Optional<Activity> origin = activityRepository.getById(id);
        if (origin.isPresent()) {
            if (origin.get().getOrganizerId() == orgId) {
                return activityRepository.deleteActivity(id);
            }
        }
        //TODO
        return -1;
    }
}
