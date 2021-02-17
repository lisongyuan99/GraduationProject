package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.generator.mapper.*;
import cn.lsy99.api.activity.generator.table.Organizer;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import static cn.lsy99.api.activity.generator.mapper.OrganizerDynamicSqlSupport.organizer;
import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.*;
import static cn.lsy99.api.activity.generator.mapper.OrganizerCustomerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class AuthRepository {

    @Resource
    private OrganizerMapper organizerMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private OrganizerCustomerMapper organizerCustomerMapper;

    private final static int newRole = UserRole.ORG.ordinal();

    /**
     * 通过微信OpenId选择商家
     *
     * @param openId 微信OpenId
     * @return 商家类
     */
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

    /**
     * 通过微信OpenId添加商家
     *
     * @param openId openid
     * @return 添加商家的信息
     */
    public Organizer insertOrganizerByOpenId(String openId) {
        Date now = new Date();
        Organizer organizer = Organizer.builder().wxOpenId(openId).type(newRole).createTime(now).updateTime(now).build();
        int insertResult = organizerMapper.insertSelective(organizer);
        log.info(String.valueOf(insertResult));
        return organizer;
    }

    /**
     * 更新商家信息
     *
     * @param organizer 商家信息
     * @return 更新结果
     */
    public boolean updateOrganzier(Organizer organizer) {
        if (organizer.getId() == null) {
            return false;
        }
        return organizerMapper.updateByPrimaryKey(organizer) == 1;
    }

    /**
     * 获取所有活动个数
     *
     * @param organizerId 商家id
     * @return 活动个数
     */
    public long getActivityCount(int organizerId) {
        SelectStatementProvider selectStatementProvider = SqlBuilder.select(count(activity.allColumns()))
                .from(activity)
                .where(activity.organizerId, isEqualTo(organizerId))
                .build().render(RenderingStrategies.MYBATIS3);
        return activityMapper.count(selectStatementProvider);
    }

    /**
     * 获取粉丝个数
     *
     * @param organizerId 商家id
     * @return 粉丝个数
     */
    public long getFollowerCount(int organizerId) {
        SelectStatementProvider selectStatementProvider = SqlBuilder.select(count(organizerCustomer.allColumns()))
                .from(organizerCustomer)
                .where(organizerCustomer.organizerId, isEqualTo(organizerId))
                .build().render(RenderingStrategies.MYBATIS3);
        return organizerCustomerMapper.count(selectStatementProvider);
    }
}
