package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivityStatisticsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6197005+08:00", comments="Source Table: activity_statistics")
    public static final ActivityStatistics activityStatistics = new ActivityStatistics();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6197005+08:00", comments="Source field: activity_statistics.activity_id")
    public static final SqlColumn<Integer> activityId = activityStatistics.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6197005+08:00", comments="Source field: activity_statistics.visits")
    public static final SqlColumn<String> visits = activityStatistics.visits;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6197005+08:00", comments="Source field: activity_statistics.organizer_id")
    public static final SqlColumn<Integer> organizerId = activityStatistics.organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6197005+08:00", comments="Source Table: activity_statistics")
    public static final class ActivityStatistics extends SqlTable {
        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<String> visits = column("visits", JDBCType.VARCHAR);

        public final SqlColumn<Integer> organizerId = column("organizer_id", JDBCType.INTEGER);

        public ActivityStatistics() {
            super("activity_statistics");
        }
    }
}