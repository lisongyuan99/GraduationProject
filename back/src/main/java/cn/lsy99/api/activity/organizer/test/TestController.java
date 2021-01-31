package cn.lsy99.api.activity.organizer.test;

import cn.lsy99.api.activity.organizer.auth.annotation.InputCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @GetMapping("/all")
    public String hello() {
        return"hello all";
    }
    @GetMapping("/registered")
    public String hello2() {
        return"hello registered";
    }
    @GetMapping("/user")
    public String user() {
        return"hello user";
    }
    @GetMapping("/org")
    public String org() {
        return"hello org";
    }
    @GetMapping("/cert")
    public String cert() {
        return"hello cert";
    }
    @GetMapping("/admin")
    public String admin() {
        return"hello admin";
    }

    @PostMapping("test")
    @InputCheck
    public String aopTest (String username, String password) {
        log.info(username);
        log.info(password);
        return "123";
    }

}
