package cn.lsy99.api.activity.follower;

import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.generator.table.Customer;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("remove")
    public boolean remove(@RequestHeader("Token")String token, @RequestBody int followerId){
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int organizerId = jwtInfo.getId();
        return followerService.removeFollower(organizerId, followerId);
    }
}
