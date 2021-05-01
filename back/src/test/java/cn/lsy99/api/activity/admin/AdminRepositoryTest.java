package cn.lsy99.api.activity.admin;

import cn.lsy99.api.activity.generator.mapper.ActivitySuggestionMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import static cn.lsy99.api.activity.generator.mapper.ActivitySuggestionDynamicSqlSupport.activitySuggestion;

@Slf4j
@SpringBootTest
class AdminRepositoryTest {
    @Autowired
    private ActivitySuggestionMapper activitySuggestionMapper;

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