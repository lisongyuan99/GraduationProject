package cn.lsy99.api.activity.visit;

import cn.lsy99.api.activity.generator.mapper.ActivityMapper;
import cn.lsy99.api.activity.generator.mapper.ActivityStatisticsMapper;
import cn.lsy99.api.activity.generator.mapper.CategoryMapper;
import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.ActivityStatistics;
import cn.lsy99.api.activity.util.ArrayUtil;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.activity;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThan;

@Repository
public class VisitRepository {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private ActivityStatisticsMapper activityStatisticsMapper;
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
}
