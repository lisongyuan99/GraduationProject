package cn.lsy99.api.activity.user;

import cn.lsy99.api.activity.generator.mapper.OrganizerMapper;
import cn.lsy99.api.activity.generator.table.Organizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private OrganizerMapper organizerMapper;

    // 绑定电话号
    public int bindPhone(Organizer organizer) {
        return organizerMapper.updateByPrimaryKeySelective(organizer);
    }

    // 获取用户资料
    public Optional<Organizer> getUserProfile(int id) {
        return organizerMapper.selectByPrimaryKey(id);
    }

    public int updateUserProfile(Organizer organizer) {
        return organizerMapper.updateByPrimaryKeySelective(organizer);
    }
}
