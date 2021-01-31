package cn.lsy99.api.activity.organizer.follower;

import cn.lsy99.api.activity.organizer.auth.dto.JwtInfo;
import cn.lsy99.api.activity.organizer.generator.table.Customer;
import cn.lsy99.api.activity.organizer.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("follower")
public class FollowerController {
    @Autowired
    private FollowerService followerService;

    @PostMapping("all")
    public List<Customer> all(@RequestHeader("Token") String token) {
//        System.out.println(token);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return followerService.getAllFollower(jwtInfo.getId());
    }
}
