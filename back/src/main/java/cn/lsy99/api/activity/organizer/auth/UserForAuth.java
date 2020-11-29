package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.table.Organizer;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@Builder
public class UserForAuth implements UserDetails {
    private Organizer organizer;

    @Autowired
    private JWTUtil jwtUtil;

    @Value("${organizer.type.org}")
    private int TYPE_ORG;

    @Value("${organizer.type.cert}")
    private int TYPE_CERT;

    @Value("${orgainzer.password}")
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return jwtUtil.getAuthoritiesFromType(organizer.getType());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return String.valueOf(organizer.getId());
    }

    // 账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账号是否没锁住，锁住的用户无法认证
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否没过期，密码过期的用户无法认证
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 用户是否使能，未使能的用户无法认证
    @Override
    public boolean isEnabled() {
        return true;
    }

}
