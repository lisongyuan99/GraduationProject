package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.mapper.OrganizerMapper;
import cn.lsy99.api.activity.organizer.mapper.UserMapper;
import cn.lsy99.api.activity.organizer.table.Organizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import static cn.lsy99.api.activity.organizer.mapper.OrganizerDynamicSqlSupport.organizer;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class AuthRepository {

    @Resource
    private OrganizerMapper organizerMapper;

    @Value("${organizer.type.org}")
    private int TYPE_ORG;

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
        Organizer organizer = Organizer.builder().wxOpenId(openId).type(TYPE_ORG).createTime(now).updateTime(now).build();
        int insertResult = organizerMapper.insertSelective(organizer);
        log.info(String.valueOf(insertResult));
        return organizer;
    }
}
