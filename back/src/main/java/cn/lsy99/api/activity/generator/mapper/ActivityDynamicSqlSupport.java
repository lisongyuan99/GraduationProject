package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5816492+08:00", comments="Source Table: activity")
    public static final Activity activity = new Activity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5826493+08:00", comments="Source field: activity.id")
    public static final SqlColumn<Integer> id = activity.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5826493+08:00", comments="Source field: activity.title")
    public static final SqlColumn<String> title = activity.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.detail")
    public static final SqlColumn<String> detail = activity.detail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.subtitle")
    public static final SqlColumn<String> subtitle = activity.subtitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.begin_time")
    public static final SqlColumn<Date> beginTime = activity.beginTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.end_time")
    public static final SqlColumn<Date> endTime = activity.endTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.time_type")
    public static final SqlColumn<Integer> timeType = activity.timeType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.organizer_id")
    public static final SqlColumn<Integer> organizerId = activity.organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.category")
    public static final SqlColumn<Integer> category = activity.category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.pos_lat")
    public static final SqlColumn<Double> posLat = activity.posLat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.pos_lng")
    public static final SqlColumn<Double> posLng = activity.posLng;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.create_time")
    public static final SqlColumn<Date> createTime = activity.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.update_time")
    public static final SqlColumn<Date> updateTime = activity.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.position_code")
    public static final SqlColumn<Integer> positionCode = activity.positionCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.position_detail")
    public static final SqlColumn<String> positionDetail = activity.positionDetail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.prize")
    public static final SqlColumn<Double> prize = activity.prize;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.popularity")
    public static final SqlColumn<Double> popularity = activity.popularity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.pics")
    public static final SqlColumn<String> pics = activity.pics;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5836464+08:00", comments="Source field: activity.status")
    public static final SqlColumn<Integer> status = activity.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.5826493+08:00", comments="Source Table: activity")
    public static final class Activity extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> detail = column("detail", JDBCType.VARCHAR);

        public final SqlColumn<String> subtitle = column("subtitle", JDBCType.VARCHAR);

        public final SqlColumn<Date> beginTime = column("begin_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> endTime = column("end_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> timeType = column("time_type", JDBCType.INTEGER);

        public final SqlColumn<Integer> organizerId = column("organizer_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> category = column("category", JDBCType.INTEGER);

        public final SqlColumn<Double> posLat = column("pos_lat", JDBCType.DOUBLE);

        public final SqlColumn<Double> posLng = column("pos_lng", JDBCType.DOUBLE);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> positionCode = column("position_code", JDBCType.INTEGER);

        public final SqlColumn<String> positionDetail = column("position_detail", JDBCType.VARCHAR);

        public final SqlColumn<Double> prize = column("prize", JDBCType.DOUBLE);

        public final SqlColumn<Double> popularity = column("popularity", JDBCType.DOUBLE);

        public final SqlColumn<String> pics = column("pics", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public Activity() {
            super("activity");
        }
    }
}