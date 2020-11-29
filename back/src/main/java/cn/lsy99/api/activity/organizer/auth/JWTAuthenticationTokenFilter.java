package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.error.ErrorResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
@Slf4j
public class JWTAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    JWTUtil jwtUtil;
    private static final String tokenHeader = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 从http头部读取jwt
        String token = httpServletRequest.getHeader(tokenHeader);
        log.info(token == null ? "no token" : token);
        String id = null;
        Collection<? extends GrantedAuthority> role = null;

        // 从jwt中解出账号与角色信息
        // TODO 判断token是否过期
        if (token != null) {
            try {
                id = jwtUtil.getIdFromToken(token);
                role = jwtUtil.getAuthoritiesFromToken(token);
                // 如果jwt正确解出账号信息，说明是合法用户，设置认证信息，认证通过
                if (id != null && role != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            id, null, role);
                    // 把请求的信息设置到UsernamePasswordAuthenticationToken details对象里面，包括发请求的ip等
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    // 设置认证信息
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } catch (Exception e) {
                httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                httpServletResponse.getWriter().write(ErrorResponseBody.builder()
                        .code("InvalidToken")
                        .message("无效Token")
                        .build().toJsonString());
                return;
            }
        }
        // 调用下一个过滤器
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
