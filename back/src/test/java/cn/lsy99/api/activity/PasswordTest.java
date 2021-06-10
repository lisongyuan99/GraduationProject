package cn.lsy99.api.activity;

import cn.lsy99.api.activity.generator.mapper.ActivitySuggestionMapper;
import cn.lsy99.api.activity.shop.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class PasswordTest {
    @Autowired
    private ActivitySuggestionMapper activitySuggestionMapper;
    @Autowired
    private ShopRepository shopRepository;

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

}