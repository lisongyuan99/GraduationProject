package cn.lsy99.api.activity.follower;

import cn.lsy99.api.activity.aop.annotation.BossTokenCheck;
import cn.lsy99.api.activity.follower.dto.CustomerInfo;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("follower")
public class FollowerController {
    @Value("${http.token.header}")
    private String tokenHeader;

    @Autowired
    private FollowerService followerService;

    @BossTokenCheck
    @GetMapping("all")
    public List<CustomerInfo> all(@RequestHeader Map<String, String> headers) {
        // System.out.println(headers.toString());
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return followerService.getAllFollower(jwtInfo.getId());
    }

    @BossTokenCheck
    @PostMapping("remove")
    public boolean remove(@RequestHeader Map<String, String> headers, @RequestBody int followerId) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int organizerId = jwtInfo.getId();
        return followerService.removeFollower(organizerId, followerId);
    }

}
