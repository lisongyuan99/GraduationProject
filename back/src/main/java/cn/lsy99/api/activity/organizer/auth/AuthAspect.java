package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.auth.exception.InvalidUsernameException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AuthAspect {
    @Pointcut("@annotation(cn.lsy99.api.activity.organizer.auth.annotation.InputCheck)")
    public void pointInputCheck(){}

    @Before("pointInputCheck()")
    public void inputCheck(JoinPoint jp) {
        Object[] args = jp.getArgs();
        log.info(Arrays.toString(args));
        if (args[0] != null && args[1] != null) {
            String username = args[0].toString();
            String password = args[1].toString();
            if(!username.matches("[\\w\\d-_]+")){
                throw new InvalidUsernameException();
            }
        }
    }

}
