package cn.lsy99.api.activity.follower;

import cn.lsy99.api.activity.generator.mapper.CustomerMapper;
import cn.lsy99.api.activity.generator.mapper.OrganizerMapper;
import cn.lsy99.api.activity.generator.mapper.ShopFollowMapper;
import cn.lsy99.api.activity.generator.table.Customer;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static cn.lsy99.api.activity.generator.mapper.CustomerDynamicSqlSupport.customer;
import static cn.lsy99.api.activity.generator.mapper.OrganizerDynamicSqlSupport.organizer;
import static cn.lsy99.api.activity.generator.mapper.ShopFollowDynamicSqlSupport.shopFollow;
import static org.mybatis.dynamic.sql.SqlBuilder.*;


@Repository
public class FollowerRepository {
    @Resource
    CustomerMapper customerMapper;
    @Resource
    ShopFollowMapper shopFollowMapper;
    @Resource
    OrganizerMapper organizerMapper;

    public List<Customer> getAllFollower(int organizerId) {
        SelectStatementProvider selectStatementProvider = SqlBuilder.select(customer.allColumns())
                .from(organizer)
                .join(shopFollow).on(organizer.id, equalTo(shopFollow.organizerId))
                .join(customer).on(shopFollow.customerId, equalTo(customer.id))
                .where(organizer.id, isEqualTo(organizerId))
                .build().render(RenderingStrategies.MYBATIS3);
        return customerMapper.selectMany(selectStatementProvider);
    }

    public boolean removeFollower(int organizerId, int followerId) {
        DeleteStatementProvider deleteStatementProvider = deleteFrom(shopFollow)
                .where(shopFollow.organizerId, isEqualTo(organizerId))
                .and(shopFollow.customerId, isEqualTo(followerId))
                .build().render(RenderingStrategies.MYBATIS3);
        return shopFollowMapper.delete(deleteStatementProvider) > 0;
    }
}