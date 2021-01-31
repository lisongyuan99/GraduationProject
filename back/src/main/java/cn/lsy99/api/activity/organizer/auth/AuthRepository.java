package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.generator.UserRole;
import cn.lsy99.api.activity.organizer.generator.mapper.OrganizerMapper;
import cn.lsy99.api.activity.organizer.generator.table.Organizer;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import static cn.lsy99.api.activity.organizer.generator.mapper.OrganizerDynamicSqlSupport.organizer;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class AuthRepository {

    @Resource
    private OrganizerMapper organizerMapper;

    final static int newRole = UserRole.ORG.ordinal();

    public Organizer selectOrganizerByOpenId(String openId) {
        List<Organizer> result = organizerMapper.select(c -> c.where(organizer.wxOpenId, isEqualTo(openId)));
        if (result.size() == 1) {
            return result.get(0);
        } else if (result.size() == 0) {
            return null;
        } else {
            //TODO 会有两个吗……
            return result.get(0);
        }
    }

    public Organizer insertOrganizerByOpenId(String openId) {
        Date now = new Date();
        Organizer organizer = Organizer.builder().wxOpenId(openId).type(newRole).createTime(now).updateTime(now).build();
        int insertResult = organizerMapper.insertSelective(organizer);
        log.info(String.valueOf(insertResult));
        return organizer;
    }

    public boolean updateOrganzier(Organizer organizer) {
        if (organizer.getId() == null) {
            return false;
        }
        return organizerMapper.updateByPrimaryKey(organizer) == 1;
    }
}
