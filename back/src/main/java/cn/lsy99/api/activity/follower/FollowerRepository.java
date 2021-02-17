package cn.lsy99.api.activity.follower;

import cn.lsy99.api.activity.generator.mapper.*;
import cn.lsy99.api.activity.generator.mapper.CustomerMapper;
import cn.lsy99.api.activity.generator.mapper.OrganizerCustomerMapper;
import cn.lsy99.api.activity.generator.mapper.OrganizerMapper;
import cn.lsy99.api.activity.generator.table.Customer;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static cn.lsy99.api.activity.generator.mapper.OrganizerCustomerDynamicSqlSupport.*;
import static cn.lsy99.api.activity.generator.mapper.OrganizerDynamicSqlSupport.*;
import static cn.lsy99.api.activity.generator.mapper.CustomerDynamicSqlSupport.*;


@Repository
public class FollowerRepository {
    @Resource
    CustomerMapper customerMapper;
    @Resource
    OrganizerCustomerMapper organizerCustomerMapper;
    @Resource
    OrganizerMapper organizerMapper;

    public List<Customer> getAllFollower(int organizerId) {
        SelectStatementProvider selectStatementProvider = SqlBuilder.select(customer.allColumns())
                .from(organizer)
                .join(organizerCustomer).on(organizer.id, equalTo(organizerCustomer.organizerId))
                .join(customer).on(organizerCustomer.customerId, equalTo(customer.id))
                .where(organizer.id, isEqualTo(organizerId))
                .build().render(RenderingStrategies.MYBATIS3);
        return customerMapper.selectMany(selectStatementProvider);
    }

    public boolean removeFollower(int organizerId, int followerId) {
        DeleteStatementProvider deleteStatementProvider = deleteFrom(organizerCustomer)
                .where(organizerCustomer.organizerId, isEqualTo(organizerId))
                .and(organizerCustomer.customerId, isEqualTo(followerId))
                .build().render(RenderingStrategies.MYBATIS3);
        return organizerCustomerMapper.delete(deleteStatementProvider) > 0;
    }
}