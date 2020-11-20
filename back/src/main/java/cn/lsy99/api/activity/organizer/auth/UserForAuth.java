package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.table.Organizer;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@Builder
public class UserForAuth implements UserDetails {
    private Organizer organizer;

//    public static Collection<? extends GrantedAuthority> getAuthoritiesByRole(String role) {
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        List<String> roles = Arrays.asList(role.split(","));
//        if (roles.contains("user")) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//        if (roles.contains("admin")) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        }
//        return authorities;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        String[] roles = organizer.getRole().split(",");
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return organizer.getPassword();
    }

    @Override
    public String getUsername() {
        return organizer.getUsername();
    }

    public int getUserId() {
        return this.organizer.getId();
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
