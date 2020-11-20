package cn.lsy99.api.activity.organizer.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: activity")
    public static final Activity activity = new Activity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.id")
    public static final SqlColumn<Integer> id = activity.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.title")
    public static final SqlColumn<String> title = activity.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.time")
    public static final SqlColumn<Date> time = activity.time;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.subtitle")
    public static final SqlColumn<String> subtitle = activity.subtitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.big_pic")
    public static final SqlColumn<String> bigPic = activity.bigPic;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.small_pic")
    public static final SqlColumn<String> smallPic = activity.smallPic;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.organizer_id")
    public static final SqlColumn<Integer> organizerId = activity.organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.category")
    public static final SqlColumn<Integer> category = activity.category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.create_time")
    public static final SqlColumn<Date> createTime = activity.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.update_time")
    public static final SqlColumn<Date> updateTime = activity.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: activity.content")
    public static final SqlColumn<String> content = activity.content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: activity")
    public static final class Activity extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<Date> time = column("time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> subtitle = column("subtitle", JDBCType.VARCHAR);

        public final SqlColumn<String> bigPic = column("big_pic", JDBCType.VARCHAR);

        public final SqlColumn<String> smallPic = column("small_pic", JDBCType.VARCHAR);

        public final SqlColumn<Integer> organizerId = column("organizer_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> category = column("category", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> content = column("content", JDBCType.LONGVARCHAR);

        public Activity() {
            super("activity");
        }
    }
}