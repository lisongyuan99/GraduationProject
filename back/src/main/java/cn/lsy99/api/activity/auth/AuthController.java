package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.aop.annotation.OrgTokenCheck;
import cn.lsy99.api.activity.auth.dto.CountsOnMainPage;
import cn.lsy99.api.activity.auth.dto.LoginInput;
import cn.lsy99.api.activity.auth.dto.LoginResult;
import cn.lsy99.api.activity.follower.dto.CustomerInfo;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public LoginResult login(@RequestBody LoginInput loginInput) {
        return authService.login(loginInput);
    }

    @GetMapping("getHomepageCounts")
    @OrgTokenCheck
    public CountsOnMainPage getCounts(@RequestHeader Map<String, String> headers) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int organizerId = jwtInfo.getId();
        return authService.getCounts(organizerId);
    }
}
