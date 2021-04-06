package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.activity.dto.*;
import cn.lsy99.api.activity.aop.annotation.OrgTokenCheck;
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

    @OrgTokenCheck
    @PostMapping("add")
    public int add(@RequestHeader Map<String, String> headers, @RequestBody ActivityModifyEntity activityModifyEntity) {
//        String token = headers.get(tokenHeader);
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
//        log.info(addActivityEntity.toString());
//        log.info(jwtInfo.toString());
        // if(addActivityEntity.getName()==null!!)
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

    @OrgTokenCheck
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

    @PostMapping("removeUser")
    public int removeUser(@RequestBody RemoveUserInput input) {
        return activityService.removeUser(input.getActivityId(), input.getUserId());
    }

    @PostMapping("getByIdForEdit")
    public ActivityModifyEntity getByIdForEdit(@RequestBody int id) {
        log.info(String.valueOf(id));
        return activityService.getByIdForEdit(id);
    }

    @OrgTokenCheck
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

    @OrgTokenCheck
    @PostMapping("delete")
    public int editActivity(@RequestHeader Map<String, String> headers, @RequestBody int id) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return activityService.deleteActivity(jwtInfo.getId(), id);
    }
}
