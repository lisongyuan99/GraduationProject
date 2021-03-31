package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.activity.dto.ActivityBriefInfo;
import cn.lsy99.api.activity.activity.dto.ActivityInfo;
import cn.lsy99.api.activity.activity.dto.AddActivityEntity;
import cn.lsy99.api.activity.aop.annotation.OrgTokenCheck;
import cn.lsy99.api.activity.exception.exception.InputFieldException;
import cn.lsy99.api.activity.generator.table.Activity;
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

    @OrgTokenCheck
    @PostMapping("add")
    public int add(@RequestHeader Map<String, String> headers, @RequestBody AddActivityEntity addActivityEntity) {
//        String token = headers.get(tokenHeader);
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
//        log.info(addActivityEntity.toString());
//        log.info(jwtInfo.toString());
        // if(addActivityEntity.getName()==null!!)
        if (StringUtils.isEmpty(addActivityEntity.getName()) || StringUtils.isEmpty(addActivityEntity.getDate())) {
            throw new InputFieldException();// 异常处理
        } else {
            return activityService.addActivity(jwtInfo.getId(), addActivityEntity);
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
    public ActivityInfo getById(@RequestBody int id){
        log.info(String.valueOf(id));
        return activityService.getById(id);
    }
}
