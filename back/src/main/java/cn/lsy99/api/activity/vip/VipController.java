package cn.lsy99.api.activity.vip;

import cn.lsy99.api.activity.aop.annotation.BossTokenCheck;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import cn.lsy99.api.activity.vip.dto.VipInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("vip")
public class VipController {
    @Autowired
    private VipService vipService;
    @Value("${http.token.header}")
    private String tokenHeader;

    @BossTokenCheck
    @GetMapping("getInfo")
    public VipInfo getInfo(@RequestHeader Map<String, String> headers) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return vipService.getVipInfo(jwtInfo.getId());
    }

    @BossTokenCheck
    @PostMapping("renew")
    public boolean renew(@RequestHeader Map<String, String> headers, @RequestBody String body){
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        log.info(body);
        // return vipService.renew(jwtInfo.getId(), 30, 30);
        if(body.equals("m")){
            return vipService.renew(jwtInfo.getId(), 30, 30);
        } else if (body.equals("y")){
            return vipService.renew(jwtInfo.getId(), 365, 300);
        } else {
            return false;
        }
    }

}
