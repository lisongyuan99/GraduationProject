package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivityFollowDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.6726163+08:00", comments="Source Table: activity_follow")
    public static final ActivityFollow activityFollow = new ActivityFollow();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.6736107+08:00", comments="Source field: activity_follow.id")
    public static final SqlColumn<Integer> id = activityFollow.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.6736107+08:00", comments="Source field: activity_follow.activity_id")
    public static final SqlColumn<Integer> activityId = activityFollow.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.6736107+08:00", comments="Source field: activity_follow.customer_id")
    public static final SqlColumn<Integer> customerId = activityFollow.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.6736107+08:00", comments="Source Table: activity_follow")
    public static final class ActivityFollow extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public ActivityFollow() {
            super("activity_follow");
        }
    }
}