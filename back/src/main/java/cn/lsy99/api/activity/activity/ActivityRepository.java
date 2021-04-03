package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.generator.mapper.ActivityMapper;
import cn.lsy99.api.activity.generator.mapper.ActivityStatisticsMapper;
import cn.lsy99.api.activity.generator.mapper.CategoryMapper;
import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.ActivityStatistics;
import cn.lsy99.api.activity.generator.table.Category;
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

import static cn.lsy99.api.activity.generator.mapper.ActivityStatisticsDynamicSqlSupport.activityStatistics;
import static cn.lsy99.api.activity.generator.mapper.CategoryDynamicSqlSupport.category;
import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.activity;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThan;

@Slf4j
@Repository
public class ActivityRepository {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private ActivityStatisticsMapper activityStatisticsMapper;

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
        return activityMapper.select(c -> c.where(activity.organizerId, isEqualTo(id)));
    }

    public Optional<Activity> getById(int id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    public List<Activity> getActivitiesId(int limit) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(activity.id, activity.organizerId)
                .from(activity)
                .orderBy(activity.id)
                .limit(limit)
                .build().render(RenderingStrategies.MYBATIS3);
        return activityMapper.selectMany(selectStatementProvider);
    }

    public List<Activity> getActivitiesId(int lastId, int limit) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(activity.id, activity.organizerId)
                .from(activity)
                .where(activity.id, isGreaterThan(lastId))
                .orderBy(activity.id)
                .limit(limit)
                .build().render(RenderingStrategies.MYBATIS3);
        return activityMapper.selectMany(selectStatementProvider);
    }

    public int insertActivityCount(int activityId, int organizerId, int count) {
        Optional<ActivityStatistics> activityStatistics = activityStatisticsMapper.selectByPrimaryKey(activityId);
        if (activityStatistics.isPresent()) {
            String oldString = activityStatistics.get().getVisits();
            String newString;
            if (oldString.length() == 0) {
                newString = String.valueOf(count);
            } else {
                newString = oldString + ArrayUtil.getDivider() + count;
            }
            return activityStatisticsMapper.updateByPrimaryKeySelective(ActivityStatistics.builder()
                    .activityId(activityId)
                    .visits(newString)
                    .build());
        } else {
            return activityStatisticsMapper.insert(ActivityStatistics.builder()
                    .activityId(activityId)
                    .organizerId(organizerId)
                    .visits(String.valueOf(count))
                    .build());
        }
    }

    public List<ActivityStatistics> test(){
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(activityStatistics.allColumns())
                .from(activityStatistics)
                .orderBy(activityStatistics.activityId)
                .build().render(RenderingStrategies.MYBATIS3);
        return activityStatisticsMapper.selectMany(selectStatementProvider);
    }
}
