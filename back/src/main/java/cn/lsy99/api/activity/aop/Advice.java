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

    @Value("${http.token.header}")
    private String tokenHeader;

    //  判断token是否正确以及角色是否是BOSS
    @Before("@annotation(cn.lsy99.api.activity.aop.annotation.BossTokenCheck)")
    public void bossTokenCheck(JoinPoint point) {
        System.out.println("check");
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if (sra != null) {
            HttpServletRequest request = sra.getRequest();
            String token = request.getHeader(tokenHeader);
            if (token == null) {
                throw new NoTokenException();
            }
            JwtInfo info = JwtUtil.getInfoFromToken(token);
            if (info.getRole() != UserRole.BOSS) {
                throw new ForbiddenException();
            }
        } else {
            throw new NoTokenException();
        }
    }

    @Before("@annotation(cn.lsy99.api.activity.aop.annotation.AdminTokenCheck)")
    public void adminTokenCheck(JoinPoint point) {
        System.out.println("check");
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if (sra != null) {
            HttpServletRequest request = sra.getRequest();
            String token = request.getHeader(tokenHeader);
            if (token == null) {
                throw new NoTokenException();
            }
            JwtInfo info = JwtUtil.getInfoFromToken(token);
            if (info.getRole() != UserRole.ADMIN) {
                throw new ForbiddenException();
            }
        } else {
            throw new NoTokenException();
        }
    }

    @Before("@annotation(cn.lsy99.api.activity.aop.annotation.SellerTokenCheck)")
    public void sellerTokenCheck(JoinPoint point) {
        System.out.println("check");
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if (sra != null) {
            HttpServletRequest request = sra.getRequest();
            String token = request.getHeader(tokenHeader);
            if (token == null) {
                throw new NoTokenException();
            }
            JwtInfo info = JwtUtil.getInfoFromToken(token);
            if (!(info.getRole() == UserRole.BOSS || info.getRole() != UserRole.WORKER)) {
                throw new ForbiddenException();
            }
        } else {
            throw new NoTokenException();
        }
    }

    @Before("@annotation(cn.lsy99.api.activity.aop.annotation.TokenCheck)")
    public void tokenCheck(JoinPoint point) {
        System.out.println("check");
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if (sra != null) {
            HttpServletRequest request = sra.getRequest();
            String token = request.getHeader(tokenHeader);
            if (token == null) {
                throw new NoTokenException();
            }
            JwtInfo info = JwtUtil.getInfoFromToken(token);
        } else {
            throw new NoTokenException();
        }
    }

}
