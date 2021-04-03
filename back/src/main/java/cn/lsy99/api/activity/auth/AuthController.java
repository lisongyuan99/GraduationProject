package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.aop.annotation.OrgTokenCheck;
import cn.lsy99.api.activity.auth.dto.DataOnMainPage;
import cn.lsy99.api.activity.auth.dto.LoginResult;
import cn.lsy99.api.activity.auth.dto.WechatUserInfo;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {
    @Value("${http.token.header}")
    private String tokenHeader;

    @Autowired
    AuthService authService;

    @PostMapping("login")
    public LoginResult login(@RequestBody String loginCode) {
        return authService.login(loginCode);
    }

    // TODO token check
    @PostMapping("setWechatUserInfo")
    public boolean setUserinfo(@RequestHeader Map<String, String> headers, @RequestBody WechatUserInfo wechatUserInfo){
        log.info(wechatUserInfo.toString());
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int organizerId = jwtInfo.getId();
        return authService.setWechatUserInfo(organizerId, wechatUserInfo);
    }

    @GetMapping("getHomepageCounts")
    @OrgTokenCheck
    public DataOnMainPage getCounts(@RequestHeader Map<String, String> headers) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int organizerId = jwtInfo.getId();
        return authService.getCounts(organizerId);
    }
}
