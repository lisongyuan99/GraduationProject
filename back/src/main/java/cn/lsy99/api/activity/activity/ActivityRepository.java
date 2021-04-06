package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.generator.mapper.*;
import cn.lsy99.api.activity.generator.table.*;
import cn.lsy99.api.activity.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.ActivityCustomerDynamicSqlSupport.activityCustomer;
import static cn.lsy99.api.activity.generator.mapper.ActivityCustomerDynamicSqlSupport.activityId;
import static cn.lsy99.api.activity.generator.mapper.ActivityStatisticsDynamicSqlSupport.activityStatistics;
import static cn.lsy99.api.activity.generator.mapper.CategoryDynamicSqlSupport.category;
import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.activity;
import static cn.lsy99.api.activity.generator.mapper.CustomerDynamicSqlSupport.customer;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Repository
public class ActivityRepository {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private ActivityStatisticsMapper activityStatisticsMapper;
    @Resource
    private ActivityCustomerMapper activityCustomerMapper;
    @Resource
    CustomerMapper customerMapper;

    public List<Category> getAllCategory() {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(category.allColumns())
                .from(category)
                .build().render(RenderingStrategies.MYBATIS3);
        return categoryMapper.selectMany(selectStatementProvider);
    }

    public int addActivity(Activity activity) {
        // return activityMapper.insert(activity);
        activityMapper.insertSelective(activity);
        // log.info(activity.toString());
        return activity.getId();
    }

    public List<Activity> getMyActivity(int id) {
        // TODO 常量
        return activityMapper.select(c ->
                c.where(activity.organizerId, isEqualTo(id))
                        .and(activity.status, isNotEqualTo(1))
        );
    }

    public Optional<Activity> getById(int id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    public long getUserNum(int id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder.select(count(activityCustomer.allColumns()))
                .from(activityCustomer)
                .where(activityCustomer.activityId, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return activityCustomerMapper.count(selectStatementProvider);
    }

    public List<Customer> getUser(int id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(customer.allColumns())
                .from(activityCustomer)
                .join(customer, on(activityCustomer.customerId, equalTo(customer.id)))
                .where(activityCustomer.activityId, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return customerMapper.selectMany(selectStatementProvider);
    }

    public int removeUser(int activityId, int userId) {
        return activityCustomerMapper.delete(c ->
                c.where(activityCustomer.activityId, isEqualTo(activityId))
                        .and(activityCustomer.customerId, isEqualTo(userId)));
    }

    public int editActivity(Activity activity) {
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    public int deleteActivity(int id) {
        // TODO 常量
        Activity activity = Activity.builder()
                .id(id)
                .status(1)
                .build();
        return activityMapper.updateByPrimaryKeySelective(activity);
    }
}
