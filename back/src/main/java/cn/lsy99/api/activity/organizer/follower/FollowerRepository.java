package cn.lsy99.api.activity.organizer.follower;

import cn.lsy99.api.activity.organizer.generator.mapper.CustomerMapper;
import cn.lsy99.api.activity.organizer.generator.mapper.OrganizerCustomerMapper;
import cn.lsy99.api.activity.organizer.generator.mapper.OrganizerMapper;
import cn.lsy99.api.activity.organizer.generator.table.Customer;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.join.EqualTo;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static cn.lsy99.api.activity.organizer.generator.mapper.CustomerDynamicSqlSupport.*;
import static cn.lsy99.api.activity.organizer.generator.mapper.OrganizerDynamicSqlSupport.*;
import static cn.lsy99.api.activity.organizer.generator.mapper.OrganizerCustomerDynamicSqlSupport.*;

@Repository
public class FollowerRepository {
    @Resource
    CustomerMapper customerMapper;
    @Resource
    OrganizerCustomerMapper organizerCustomerMapper;
    @Resource
    OrganizerMapper organizerMapper;

    public List<Customer> getAllFollower(int organizerId) {
        SelectStatementProvider selectStatementProvider = select(customer.allColumns())
                .from(organizer)
                .join(organizerCustomer).on(organizer.id, equalTo(organizerCustomer.organizerId))
                .join(customer).on(organizerCustomer.customerId, equalTo(customer.id))
                .where(organizer.id, isEqualTo(organizerId))
                .build().render(RenderingStrategies.MYBATIS3);
        return customerMapper.selectMany(selectStatementProvider);
    }
}
