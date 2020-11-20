package cn.lsy99.api.activity.organizer.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestControllerTest {
    @Autowired
    TestController testController;

    @Test
    public void test3() {
        testController.aopTest("user","pass");
    }
}