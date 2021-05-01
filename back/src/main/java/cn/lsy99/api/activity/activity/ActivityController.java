package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.activity.dto.*;
import cn.lsy99.api.activity.aop.annotation.BossTokenCheck;
import cn.lsy99.api.activity.exception.exception.InputFieldException;
import cn.lsy99.api.activity.generator.table.Category;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Value("${http.token.header}")
    private String tokenHeader;
    private static final int LIMIT = 2;

    @BossTokenCheck
    @PostMapping("add")
    public int add(@RequestHeader Map<String, String> headers, @RequestBody ActivityModifyEntity activityModifyEntity) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        // log.info(activityModifyEntity.toString());
        if (StringUtils.isEmpty(activityModifyEntity.getName()) || StringUtils.isEmpty(activityModifyEntity.getDate())) {
            throw new InputFieldException();// 异常处理
        } else {
            return activityService.addActivity(jwtInfo.getId(), activityModifyEntity);
        }
    }

    @GetMapping("allCategory")
    public List<Category> getAllCategory() {
        return activityService.getAllCategory();
    }

    @BossTokenCheck
    @GetMapping("my")
    public List<ActivityBriefInfo> getMy(@RequestHeader Map<String, String> headers) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return activityService.getMyActivity(jwtInfo.getId());
    }

    @PostMapping("getById")
    public ActivityInfo getById(@RequestBody int id) {
        log.info(String.valueOf(id));
        return activityService.getById(id);
    }

    @PostMapping("getUsers")
    public List<CustomerInfo> getUsers(@RequestBody int id) {
        return activityService.getUser(id);
    }

    // 移除关注用户
    // TODO 权限控制
    @PostMapping("removeUser")
    public int removeUser(@RequestBody RemoveUserInput input) {
        return activityService.removeUser(input.getActivityId(), input.getUserId());
    }

    @BossTokenCheck
    @PostMapping("getByIdForEdit")
    public ActivityModifyEntity getByIdForEdit(@RequestBody int id) {
        log.info(String.valueOf(id));
        return activityService.getByIdForEdit(id);
    }

    @BossTokenCheck
    @PostMapping("edit")
    public int editActivity(@RequestHeader Map<String, String> headers, @RequestBody ActivityModifyEntity activityModifyEntity) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        if (StringUtils.isEmpty(activityModifyEntity.getName()) || StringUtils.isEmpty(activityModifyEntity.getDate())) {
            throw new InputFieldException();// 异常处理
        } else {
            return activityService.editActivity(jwtInfo.getId(), activityModifyEntity);
        }
    }

    @BossTokenCheck
    @PostMapping("delete")
    public int deleteActivity(@RequestHeader Map<String, String> headers, @RequestBody int id) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return activityService.deleteActivity(jwtInfo.getId(), id);
    }

    @BossTokenCheck
    @GetMapping("shopAddress")
    public Address getAddress(@RequestHeader Map<String, String> headers) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return activityService.getAddress(jwtInfo.getId());
    }

//    @BossTokenCheck
//    @PostMapping("suggestion")
//    public boolean suggest(@RequestHeader Map<String, String> headers, @RequestBody double price){
//        return
//    }
}
