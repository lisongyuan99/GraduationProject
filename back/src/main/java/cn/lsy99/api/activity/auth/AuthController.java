package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.auth.dto.LoginInput;
import cn.lsy99.api.activity.auth.dto.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("login")
    public LoginResult login(@RequestBody LoginInput loginInput) {
        return authService.login(loginInput);
    }

}
