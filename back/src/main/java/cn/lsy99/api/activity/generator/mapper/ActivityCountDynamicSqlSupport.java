package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivityCountDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source Table: activity_count")
    public static final ActivityCount activityCount = new ActivityCount();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source field: activity_count.activity_id")
    public static final SqlColumn<Integer> activityId = activityCount.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source field: activity_count.count")
    public static final SqlColumn<Integer> count = activityCount.count;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source Table: activity_count")
    public static final class ActivityCount extends SqlTable {
        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> count = column("count", JDBCType.INTEGER);

        public ActivityCount() {
            super("activity_count");
        }
    }
}