package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivityVisitsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    public static final ActivityVisits activityVisits = new ActivityVisits();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source field: activity_visits.activity_id")
    public static final SqlColumn<Integer> activityId = activityVisits.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source field: activity_visits.visits")
    public static final SqlColumn<Object> visits = activityVisits.visits;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    public static final class ActivityVisits extends SqlTable {
        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<Object> visits = column("visits", JDBCType.ARRAY);

        public ActivityVisits() {
            super("activity_visits");
        }
    }
}