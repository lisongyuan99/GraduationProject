package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.generator.mapper.CategoryMapper;
import cn.lsy99.api.activity.generator.table.Category;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static cn.lsy99.api.activity.generator.mapper.CategoryDynamicSqlSupport.category;

@Repository
public class ActivityRepository {
    @Autowired
    private CategoryMapper categoryMapper;
    public List<Category> getAllCategory() {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(category.allColumns())
                .from(category)
                .build().render(RenderingStrategies.MYBATIS3);
        return categoryMapper.selectMany(selectStatementProvider);
    }
}
