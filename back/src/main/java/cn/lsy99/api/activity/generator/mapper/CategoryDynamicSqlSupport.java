package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CategoryDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6117214+08:00", comments="Source Table: category")
    public static final Category category = new Category();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6117214+08:00", comments="Source field: category.id")
    public static final SqlColumn<Integer> id = category.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6117214+08:00", comments="Source field: category.name")
    public static final SqlColumn<String> name = category.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6117214+08:00", comments="Source Table: category")
    public static final class Category extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public Category() {
            super("category");
        }
    }
}