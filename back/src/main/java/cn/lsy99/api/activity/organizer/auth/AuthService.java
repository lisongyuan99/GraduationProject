package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.auth.dto.LoginOutput;
import cn.lsy99.api.activity.organizer.table.Organizer;
import cn.lsy99.api.activity.organizer.table.User;
import cn.lsy99.api.activity.organizer.auth.exception.RegisterFailException;
import cn.lsy99.api.activity.organizer.auth.exception.UsernameAlreadyExistException;
import cn.lsy99.api.activity.organizer.mapper.OrganizerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
@Slf4j
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;
    @Resource
    private OrganizerMapper organizerMapper;
    @Autowired
    private AuthRepository authRepository;


    public LoginOutput login(String username, String password) {
        // 认证用户，认证失败抛出异常，由JwtAuthError的commence类返回401
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 如果认证通过，返回jwt
        final UserForAuth userDetails = (UserForAuth) userDetailsService.loadUserByUsername(username);
        final String token = jwtUtil.generateToken(userDetails);
        // log.info(token);

        Organizer organizer = authRepository.getOrganizerWithUsername(username).get(0);
        organizer.setPassword(null);
        return LoginOutput.builder().token(token).organizer(organizer).build();
    }

    public Map<String, Object> register(String username, String password) {
        List<User> users = authRepository.getUserWithUsername(username);
        List<Organizer> organizers = authRepository.getOrganizerWithUsername(username);
        // TODO 用户变为组织者
        if (users.size() == 0 && organizers.size() == 0) {
            String encodePassword = new BCryptPasswordEncoder().encode(password);
            Date now = new Date();
            Organizer organizer = Organizer.builder().username(username).password(encodePassword).role("org")
                    .createTime(now).updateTime(now).build();
            int result = organizerMapper.insert(organizer);
            if (result == 1) {
                Map<String, Object> map = new HashMap<>();
                map.put("message", "注册成功");
                map.put("id", organizer.getId());
                return map;
            } else {
                throw new RegisterFailException();
            }
        } else {
            // 用户名已经存在
            throw new UsernameAlreadyExistException();
        }
    }
}
