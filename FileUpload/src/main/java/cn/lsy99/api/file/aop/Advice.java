package cn.lsy99.api.file.aop;


import cn.lsy99.api.file.exception.exception.NoTokenException;
import cn.lsy99.api.file.util.JwtInfo;
import cn.lsy99.api.file.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class Advice {

    @Value("${http.token.header}")
    private String tokenHeader;

    //  判断token是否正确以及角色是否是ORG
    @Before("@annotation(cn.lsy99.api.file.aop.annotation.Check)")
    public void orgTokenCheck() {
        System.out.println("check");
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if (sra != null) {
            log.info(sra.getRequest().getHeaderNames().toString());

        }

    }

}
