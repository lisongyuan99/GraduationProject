package cn.lsy99.api.activity.organizer.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserActivityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source Table: user_activity")
    public static final UserActivity userActivity = new UserActivity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source field: user_activity.id")
    public static final SqlColumn<Integer> id = userActivity.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source field: user_activity.user_id")
    public static final SqlColumn<Integer> userId = userActivity.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source field: user_activity.activity_id")
    public static final SqlColumn<Integer> activityId = userActivity.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source Table: user_activity")
    public static final class UserActivity extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public UserActivity() {
            super("user_activity");
        }
    }
}