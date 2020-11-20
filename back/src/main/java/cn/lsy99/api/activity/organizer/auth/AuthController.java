package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.auth.annotation.InputCheck;
import cn.lsy99.api.activity.organizer.auth.dto.LoginInput;
import cn.lsy99.api.activity.organizer.auth.dto.LoginOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("login")
    // @InputCheck
    public LoginOutput login(@RequestBody LoginInput input) throws AuthenticationException {
        String username = input.getUsername();
        String password = input.getPassword();
        log.info(username);
        log.info(password);
        return authService.login(username, password);
    }

    @PostMapping("register")
    public Map<String, Object> register(@RequestBody Map<String,String> map)throws AuthenticationException {
        String username = map.get("username");
        String password = map.get("password");
//        log.info(username);
//        log.info(password);
        // TODO 检查输入
        return authService.register(username, password);
    }
}
