package cn.lsy99.api.activity.organizer;

import cn.lsy99.api.activity.organizer.auth.JWTUtil;
import cn.lsy99.api.activity.organizer.error.ErrorResponseBody;
import cn.lsy99.api.activity.organizer.test.TestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class JWTTest {
    @Autowired
    JWTUtil jwtUtil;
    @Autowired
    TestController testController;

    @Test

    public void test1() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvTmZEdDRpaUxzdVQxam1EZXhfLUFKaFQtR2FJIiwicm9sZSI6W10sImlkIjoib05mRHQ0aWlMc3VUMWptRGV4Xy1BSmhULUdhSSIsImV4cCI6MTYwNjU2OTczNCwiaWF0IjoxNjA2NDgzMzM0fQ.bY2tVy3j1bJXi7pz6rhm8yGfSmU2l8sa-7rd0ESHT4vmBxjpfEp72npN5dalwlQ_vP-XEKtyaE7dxRQL9VqeLw";
        Claims result = jwtUtil.getAllClaimsFromToken(token);
        log.info(result.toString());
        log.info(result.get("role").toString());
        log.info(jwtUtil.getAuthoritiesFromToken(token).toString());
        log.info(jwtUtil.getIdFromToken(token));
    }

    @Test
    public void test2() throws JsonProcessingException {

        String json = new ObjectMapper().writeValueAsString(
                ErrorResponseBody.builder().code("123").message("123").build());
        log.info(json);
    }


}
