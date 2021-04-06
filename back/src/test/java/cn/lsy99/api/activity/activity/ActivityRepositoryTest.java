package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.auth.AuthController;
import cn.lsy99.api.activity.auth.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ActivityRepositoryTest {

    @Autowired
    private ActivityController activityController;
    @Autowired
    private AuthService authService;

    @Test
    public void test2(){
        log.info(authService.getCounts(18).toString());
    }
}