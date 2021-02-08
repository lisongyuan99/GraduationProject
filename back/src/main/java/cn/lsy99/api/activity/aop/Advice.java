package cn.lsy99.api.activity.aop;

import cn.lsy99.api.activity.exception.exception.ForbiddenException;
import cn.lsy99.api.activity.exception.exception.InvalidUsernameException;
import cn.lsy99.api.activity.exception.exception.NoTokenException;
import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
    @Before("@annotation(cn.lsy99.api.activity.aop.annotation.InputCheck)")
    public void inputCheck(JoinPoint jp) {
        Object[] args = jp.getArgs();
        log.info(Arrays.toString(args));
        if (args[0] != null && args[1] != null) {
            String username = args[0].toString();
            String password = args[1].toString();
            if (!username.matches("[\\w\\d-_]+")) {
                throw new InvalidUsernameException();
            }
        }
    }

    //  判断token是否正确以及角色是否是ORG
    @Before("@annotation(cn.lsy99.api.activity.aop.annotation.OrgTokenCheck)")
    public void orgTokenCheck(JoinPoint point) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if (sra != null) {
            HttpServletRequest request = sra.getRequest();
            String token = request.getHeader("token");
            if (token == null) {
                throw new NoTokenException();
            }
            JwtInfo info = JwtUtil.getInfoFromToken(token);
            if (info.getRole() != UserRole.ORG) {
                throw new ForbiddenException();
            }
        } else {
            throw new NoTokenException();
        }
    }

}
