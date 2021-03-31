package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.generator.mapper.ActivityMapper;
import cn.lsy99.api.activity.generator.mapper.CategoryMapper;
import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.Category;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.CategoryDynamicSqlSupport.category;
import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.activity;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Slf4j
@Repository
public class ActivityRepository {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private ActivityMapper activityMapper;
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

    public List<Activity> getMyActivity(int id){
        return activityMapper.select(c->c.where(activity.organizerId, isEqualTo(id)));
    }

    public Optional<Activity> getById(int id){
        return activityMapper.selectByPrimaryKey(id);
    }
}
