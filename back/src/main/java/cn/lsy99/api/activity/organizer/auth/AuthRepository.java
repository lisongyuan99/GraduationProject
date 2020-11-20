package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.mapper.OrganizerMapper;
import cn.lsy99.api.activity.organizer.mapper.UserMapper;
import cn.lsy99.api.activity.organizer.table.Organizer;
import cn.lsy99.api.activity.organizer.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static cn.lsy99.api.activity.organizer.mapper.OrganizerDynamicSqlSupport.organizer;
import static cn.lsy99.api.activity.organizer.mapper.UserDynamicSqlSupport.user;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
public class AuthRepository {

    @Resource
    UserMapper userMapper;

    @Resource
    OrganizerMapper organizerMapper;

    public List<User> getUserWithUsername(String username) {
        return userMapper.select(c -> c.where(user.username, isEqualTo(username)));
    }

    public List<Organizer> getOrganizerWithUsername(String username) {
        return organizerMapper.select(c -> c.where(organizer.username, isEqualTo(username)));
    }
}
