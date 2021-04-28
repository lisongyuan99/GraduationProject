package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.auth.dto.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
}
