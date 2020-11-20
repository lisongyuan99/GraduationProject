package cn.lsy99.api.activity.organizer.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class OrganizerActivityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source Table: organizer_activity")
    public static final OrganizerActivity organizerActivity = new OrganizerActivity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source field: organizer_activity.id")
    public static final SqlColumn<Integer> id = organizerActivity.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source field: organizer_activity.organizer_id")
    public static final SqlColumn<Integer> organizerId = organizerActivity.organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source field: organizer_activity.activity_id")
    public static final SqlColumn<String> activityId = organizerActivity.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source Table: organizer_activity")
    public static final class OrganizerActivity extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> organizerId = column("organizer_id", JDBCType.INTEGER);

        public final SqlColumn<String> activityId = column("activity_id", JDBCType.VARCHAR);

        public OrganizerActivity() {
            super("organizer_activity");
        }
    }
}