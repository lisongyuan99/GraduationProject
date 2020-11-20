package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.table.Organizer;
import cn.lsy99.api.activity.organizer.mapper.OrganizerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static cn.lsy99.api.activity.organizer.mapper.OrganizerDynamicSqlSupport.organizer;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class FindUser implements UserDetailsService {
    @Resource
    OrganizerMapper organizerMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 还未成为商家
        List<Organizer> result = organizerMapper.select(c -> c.where(organizer.username, isEqualTo(s)));
        if (result.size() != 1) {
            throw new UsernameNotFoundException("");
        } else {
            return UserForAuth.builder().organizer(result.get(0)).build();
        }
    }
}
