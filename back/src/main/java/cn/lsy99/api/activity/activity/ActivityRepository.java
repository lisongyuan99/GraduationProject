package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.generator.ActivityStatus;
import cn.lsy99.api.activity.generator.mapper.*;
import cn.lsy99.api.activity.generator.table.*;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.ActivityCountDynamicSqlSupport.activityCount;
import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.activity;
import static cn.lsy99.api.activity.generator.mapper.ActivityFollowDynamicSqlSupport.activityFollow;
import static cn.lsy99.api.activity.generator.mapper.ActivitySuggestionDynamicSqlSupport.activitySuggestion;
import static cn.lsy99.api.activity.generator.mapper.CategoryDynamicSqlSupport.category;
import static cn.lsy99.api.activity.generator.mapper.CustomerDynamicSqlSupport.customer;
import static cn.lsy99.api.activity.generator.mapper.SellerDynamicSqlSupport.seller;
import static cn.lsy99.api.activity.generator.mapper.ShopDynamicSqlSupport.shop;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Repository
public class ActivityRepository {
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private ActivityStatisticsMapper activityStatisticsMapper;
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private ActivityCountMapper activityCountMapper;
    @Resource
    private ActivityFollowMapper activityFollowMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private ActivitySuggestionMapper activitySuggestionMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String ACTIVITY_PREFIX = "visit.activity:";

    // 老板id获取商铺
    public Optional<Shop> getShopByBossId(int id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(shop.allColumns())
                .from(shop)
                .join(seller)
                .on(shop.id, equalTo(seller.shopId))
                .where(seller.id, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return shopMapper.selectOne(selectStatementProvider);
    }

    // 获取所有分类
    public List<Category> getAllCategory() {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(category.allColumns())
                .from(category)
                .build().render(RenderingStrategies.MYBATIS3);
        return categoryMapper.selectMany(selectStatementProvider);
    }

    // 添加活动+初始化
    public int addActivity(Activity activity) {
        activityMapper.insertSelective(activity);
        return activity.getId();
    }

    // 初始化活动个数
    public int initCount(int id, int count) {
        ActivityCount activityCount = ActivityCount.builder()
                .activityId(id)
                .count(count)
                .build();
        return activityCountMapper.insertSelective(activityCount);
    }

    // 初始化活动统计
    public int initStatistics(int id) {
        ActivityStatistics activityStatistics = ActivityStatistics.builder()
                .activityId(id)
                .visitSum(0)
                .build();
        return activityStatisticsMapper.insertSelective(activityStatistics);
    }

    //获取我的所有活动
    public List<Activity> getMyActivity(int id) {
        return activityMapper.select(c ->
                c.where(activity.shopId, isEqualTo(id))
                        .and(activity.status, isNotEqualTo(ActivityStatus.DELETED.ordinal()))
        );
    }

    // 获取活动个数
    public int getCount(int activityId) {
        Optional<ActivityCount> count = activityCountMapper
                .selectOne(c -> c.where(activityCount.activityId, isEqualTo(activityId)));
        if(count.isPresent()){
            return count.get().getCount();
        } else {
            return 0;
        }
    }

    // 按id获取活动
    public Optional<Activity> getById(int id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    // 获取关注用户数
    public long getFollowUserNum(int id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(count(activityFollow.allColumns()))
                .from(activityFollow)
                .where(activityFollow.activityId, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return activityFollowMapper.count(selectStatementProvider);
    }

    // 获取参加用户数
    public long getJoinUserNum(int id) {
//        SelectStatementProvider selectStatementProvider = SqlBuilder
//                .select(sum(orderInfo.count))
//                .from(orderInfo)
//                .where(orderInfo.activityId, isEqualTo(id))
//                .build().render(RenderingStrategies.MYBATIS3);
//        return orderInfoMapper.count(selectStatementProvider);
        return 0;
    }

    // 获取浏览量
    public int getViewNum(int id) {
        String countString = stringRedisTemplate.opsForValue().get(ACTIVITY_PREFIX + id);
        int count = 0;
        if (countString != null) {
            count = Integer.parseInt(countString);
        }
        return count;
    }

    // 获取商家信息
    public Optional<Shop> getShopById(int id) {
        return shopMapper.selectByPrimaryKey(id);
    }

    // 获取赞
    public long getUpVoteNum(int id) {
        return 0;
    }

    // 获取踩
    public long getDownVoteNum(int id) {
        return 0;
    }

    // 获取活动关注用户
    public List<Customer> getUser(int id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(customer.allColumns())
                .from(activityFollow)
                .join(customer, on(activityFollow.customerId, equalTo(customer.id)))
                .where(activityFollow.activityId, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return customerMapper.selectMany(selectStatementProvider);
    }

    // 移除关注
    public int removeUser(int activityId, int userId) {
        return activityFollowMapper.delete(c ->
                c.where(activityFollow.activityId, isEqualTo(activityId))
                        .and(activityFollow.customerId, isEqualTo(userId)));
    }

    // 编辑活动
    public int editActivity(Activity activity) {
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    // 修改剩余活动
    public int editActivityCount(int activityId, int rest) {
        ActivityCount record = ActivityCount.builder().activityId(activityId).count(rest).build();
        return activityCountMapper.updateByPrimaryKeySelective(record);
    }

    // 删除活动(软删除)
    public int deleteActivity(int id) {
        // TODO 常量
        Activity activity = Activity.builder()
                .id(id)
                .status(ActivityStatus.DELETED.ordinal())
                .build();
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    public double getSuggestion(int activityId) {
        double result = 0;
        List<ActivitySuggestion> bills = activitySuggestionMapper
                .select(c -> c.where(activitySuggestion.activityId, isEqualTo(activityId)));
        for (ActivitySuggestion e : bills) {
            result += e.getPrice();
        }
        return result;
    }

    public int addSuggestion(int activityId, double price) {
        ActivitySuggestion record = ActivitySuggestion.builder()
                .activityId(activityId)
                .price(price)
                .addTime(new Date())
                .build();
        return activitySuggestionMapper.insertSelective(record);
    }
}
