package cn.lsy99.api.activity.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AdminRepositoryTest {
    @Test
    public void testBcrypt(){
        String password = "123456";
        //密码加密
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        // String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        if (BCrypt.checkpw(password, hashed)){
            log.info("match!");
        }
    }

    @Test
    public void testMatch(){

    }

}