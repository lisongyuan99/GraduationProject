package cn.lsy99.api.activity.organizer.config.security;

import cn.lsy99.api.activity.organizer.error.ErrorResponseBody;
import cn.lsy99.api.activity.organizer.error.ErrorResponseEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(
                ErrorResponseBody.builder()
                        .code("NoPermission")
                        .message("没有访问权限")
                        .build().toJsonString());
    }
}

